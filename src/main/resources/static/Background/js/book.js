$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

    //删除
    $("#btn_delete").click(function (){
        var temp= $("#bookTable").bootstrapTable('getSelections');
        if(temp.length<=0) {
            alert("请至少选中一行")
        } else {
            var content = "";
            for(var i=0;i<temp.length;i++){
                content += "ids="+temp[i].id+"&";
            }
            $.ajax({
                type: "DELETE",
                url: "/book/delBooks?"+ content,
                dataType: "json",
                success: function(data) {
                    if(data.code==="0") {
                        alert(data.msg);
                        window.location.reload();
                    }
                    else{
                        alert(data.msg);
                    }
                },
                error: function() {
                    alert("连接失败");
                }
            });
        }
    });

    //新增
    $("#btn_add").click(function(){
        $("#booModal").modal({show:true});

        //初始化
        var bookName =  $("#bookName");
        var author = $("#author");
        var ISBN = $("#ISBN");
        var price = $("#price");
        var publishCompany = $("#publishCompany");
        var state = $("#state");
        var translator = $("#translator");
        var comeUpTime = $("#comeUpTime");

        bookName.val("");
        author.val("");
        ISBN.val("");
        price.val("");
        publishCompany.val("");
        state.val("");
        translator.val("");
        comeUpTime.val("");


        //提交
        $("#btn_submit").unbind('click').bind('click',(function(){
            var userId = sessionStorage['id'];
            $.ajax({
                type: "PUT",
                url: '/book/addBook',
                data: {
                    "userId":userId,
                    "bookName": bookName.val(),
                    "author": author.val(),
                    "translator": translator.val(),
                    "price": price.val(),
                    "ISBNCode": ISBN.val(),
                    "comeUpTime": comeUpTime.val(),
                    "state":  state.val(),
                    "publishCompany":  publishCompany.val()
                },
                dataType: "json",
                success: function (data) {
                    alert(data.msg);
                    $("#booModal").modal({show: false});
                    window.location.reload();
                },
                error: function () {
                    alert("连接失败");
                    $("#booModal").modal({show: false});
                }
            });

        }));

    });


    //修改
    $("#btn_edit").click(function(){

        var temp= $("#bookTable").bootstrapTable('getSelections');
        if(temp.length<=0){
            alert("请至少选中一行");
        }else if(temp.length==1){

            $("#booModal").modal({show:true});

            //初始化
            var bookName =  $("#bookName");
            var author = $("#author");
            var ISBN = $("#ISBN");
            var price = $("#price");
            var publishCompany = $("#publishCompany");
            var state = $("#state");
            var translator = $("#translator");
            var comeUpTime = $("#comeUpTime");

            bookName.val(temp[0].bookName);
            author.val(temp[0].author);
            ISBN.val(temp[0].iSBNCode);
            price.val(temp[0].price);
            publishCompany.val(temp[0].publishCompany);
            state.val(temp[0].state);
            translator.val(temp[0].translator);
            comeUpTime.val(temp[0].comeUpTime);

            //提交
            $("#btn_submit").unbind('click').bind('click',(function(){
                $.ajax({
                    type: "POST",
                    url: '/book/updateBook',
                    data: {
                        "id":temp[0].id,
                        "bookName": bookName.val(),
                        "author": author.val(),
                        "translator": translator.val(),
                        "price": price.val(),
                        "ISBNCode": ISBN.val(),
                        "comeUpTime": comeUpTime.val(),
                        "state":  state.val(),
                        "publishCompany":  publishCompany.val()
                    },
                    dataType: "json",
                    success: function (data) {
                        alert(data.msg);
                        $("#booModal").modal({show: false});
                        window.location.reload();
                    },
                    error: function () {
                        alert("连接失败");
                        $("#booModal").modal({show: false});
                    }
                });

            }));
        }else{
            alert('最多只能选择一行');
        }
    });

});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#bookTable').bootstrapTable({
            url: '/book/bookList',         //请求后台的URL（*）
            method: 'GET',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            responseHandler: function(result) {
                console.info(result);
                return {
                    result : result
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: '图书编号'
            }, {
                field: 'bookName',
                title: '书名',
                searchable:true
            }, {
                field: 'author',
                title: '作者'
            }, {
                field: 'iSBNCode',
                title: 'ISBN'
            }, {
                field: 'price',
                title: '单价'
            }, {
                field: 'publishCompany',
                title: '出版社'
            }, {
                field: 'state',
                title: '状态',
                formatter: function (value, row, index) {
                    if(value=="0")
                        value="借出";
                    else value = "在库"
                    return  value;
                }

            }, {
                field: 'translator',
                title: '译者'
            }, {
                field: 'comeUpTime',
                title: '出版日期',
                formatter: function (value, row, index) {
                    var unixTimestamp = new Date(value) ;
                    return  unixTimestamp.toLocaleString();
                }
            }, {
                field: 'enteringDate',
                title: '入库日期',
                formatter: function (value, row, index) {
                    var unixTimestamp = new Date(value) ;
                    return  unixTimestamp.toLocaleString();
                }
            }, {
                field: 'enteringMen.id',
                title: '入库者编号',
                visible:false
            } ],
            onLoadSuccess: function(data) {
                $('#bookTable').bootstrapTable('removeAll');
                $('#bookTable').bootstrapTable('append',data.result.data.bookInfos);
            }
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset  //页码
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};
