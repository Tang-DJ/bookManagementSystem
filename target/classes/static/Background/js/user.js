$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

    //删除
    $("#btn_delete").click(function (){
        var temp= $("#userTable").bootstrapTable('getSelections');
        if(temp.length<=0) {
            alert("请至少选中一行")
        } else {
            var content = "";
            for(var i=0;i<temp.length;i++){
                content += "ids="+temp[i].id+"&";
            }
            $.ajax({
                type: "DELETE",
                url: "/user/delUsers?"+ content,
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

        $("#userModal").modal({show:true});

        //初始化
        var userName =  $("#userName");
        var departments = $("#departments");
        var major = $("#major");
        var email = $("#email");
        var phone = $("#phone");
        var password = $("#password");

        userName.val("");
        departments.val("");
        major.val("");
        email.val("");
        phone.val("");
        password.val("");

        //提交
        $("#btn_submit").unbind('click').bind('click',(function(){
            $.ajax({
                type: "post",
                url: '/user/register',
                data: {
                    "userName": userName.val(),
                    "departments": departments.val(),
                    "major": major.val(),
                    "email": email.val(),
                    "phone": phone.val(),
                    "password":hex_md5(password.val())
                },
                dataType: "json",
                success: function (data) {
                    alert(data.msg);
                    $("#userModal").modal({show: false});
                    window.location.reload();
                },
                error: function () {
                    alert("连接失败");
                    $("#userModal").modal({show: false});
                }
            });

        }));

    });

    //修改
    $("#btn_edit").click(function(){
        var temp= $("#userTable").bootstrapTable('getSelections');
        if(temp.length<=0){
            alert("请至少选中一行");
        }else if(temp.length==1){

            $("#userModal").modal({show:true});

            //初始化
            var userName =  $("#userName");
            var departments = $("#departments");
            var major = $("#major");
            var email = $("#email");
            var phone = $("#phone");
            var password = $("#password");

            userName.val(temp[0].userName);
            departments.val(temp[0].userInfoModel.departments);
            major.val(temp[0].userInfoModel.major);
            email.val(temp[0].userInfoModel.email);
            phone.val(temp[0].userInfoModel.phone);

            //提交
            $("#btn_submit").unbind('click').bind('click',(function(){
                $.ajax({
                    type: "post",
                    url: '/user/updateUser',
                    data: {
                        "userId":temp[0].id,
                        "userName": userName.val(),
                        "departments": departments.val(),
                        "major": major.val(),
                        "email": email.val(),
                        "phone": phone.val(),
                        "password":hex_md5(password.val())
                    },
                    dataType: "json",
                    success: function (data) {
                        alert(data.msg);
                        $("#userModal").modal({show: false});
                        window.location.reload();
                    },
                    error: function () {
                        alert("连接失败");
                        $("#userModal").modal({show: false});
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
        $('#userTable').bootstrapTable({
            url: '/user/userList',         //请求后台的URL（*）
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
                return {
                    result : result
                };
            },
            onLoadSuccess: function(data) {
                $('#userTable').bootstrapTable('removeAll');
                $('#userTable').bootstrapTable('append',data.result.data.userList);
            },
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: '用户编号'
            }, {
                field: 'userName',
                title: '用户名'
            }, {
                field: 'createDate',
                title: '创建时间',
                formatter: function (value, row, index) {
                    var unixTimestamp = new Date(value) ;
                    return  unixTimestamp.toLocaleString();
                }
            }, {
                field: 'userInfoModel.departments',
                title: '学院'
            }, {
                field: 'userInfoModel.major',
                title: '专业'
            }, {
                field: 'userInfoModel.email',
                title: '邮箱'
            }, {
                field: 'userInfoModel.phone',
                title: '电话'
            }, {
                field: 'userInfoModel.max',
                title: '最大借阅数'
            }, {
                field: 'userInfoModel.lendedNum',
                title: '当前借阅数'
            } ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            departmentname: $("#txt_search_departmentname").val(),
            statu: $("#txt_search_statu").val()
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