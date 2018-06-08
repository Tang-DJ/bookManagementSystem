$(function () {
    init();
    function init() {

        //图书列表
        $.ajax({
            type:"GET",
            url:"/book/simBookList",
            async:true,
            dataType: "json",
            success:function (data) {
                if(data.code==="0"){
                    var len = 6;//data.data.bookInfos.length，现在设置为6
                    var temp = "";
                    for(var i=0;i<len;i++){

                        var unixTimestamp = new Date(data.data.bookInfos[i].comeUpTime) ;
                        var tempHref = "single.html?id="+data.data.bookInfos[i].id;

                        temp+="<li class='article-entry standard'><h4><a href='"+ tempHref +"'>"
                            + data.data.bookInfos[i].bookName +"</a></h4><span class='article-meta'>"
                            + unixTimestamp.toLocaleString() +"<a href=''#' title='点击查看图书详情'>"
                            + data.data.bookInfos[i].author +"</a></span></li>";
                    }
                    $("#popular").append(temp);
                }
                else    alert(data.msg);
            }
        });

        var n1 = location.href.length;//地址的总长度
        var n2 = location.href.indexOf("=");//取得=号的位置
        var id = decodeURI(location.href.substr(n2+1, n1-n2));//从=号后面的内容

        //图书详情
        $.ajax({
            type:"GET",
            url:"/book/bookDetail",
            data: {
                id:id
            },
            async:true,
            dataType: "json",
            success:function (data) {
                if(data.code==="0") {
                    console.info(data.data.bookInfos);
                    $("#bookTitle").text(data.data.bookInfos[0].bookName);

                    var unixTimestamp = new Date(data.data.bookInfos[0].comeUpTime);
                    $("#bookComeDate").text(unixTimestamp.toLocaleString());

                    $("#bookAuthor").text(data.data.bookInfos[0].author);
                    var state;
                    if(data.data.bookInfos[0].state=="0"){
                        $("#rent").attr("disabled",true);
                        state="借出";
                    }
                    else state = "在库";

                    var temp = "<p>ISBN:" + data.data.bookInfos[0].iSBNCode + "</p>"+
                               "<p>单价:" + data.data.bookInfos[0].price + "元</p>" +
                               "<p>译者:" + data.data.bookInfos[0].translator + "</p>" +
                               "<p>出版社:" + data.data.bookInfos[0].publishCompany + "</p>" +
                               "<p>租借状态:" + state + "</p>";

                    $("#bookDetail").append(temp);
                }
                else    alert(data.msg);

            }
        });


        //借书请求
        $("#rent").click(function () {

            var userId = sessionStorage['id'];
            $.ajax({
                type:"POST",
                url:"/book/lendBook",
                data: {
                    id:id,
                    userId:userId
                },
                async:true,
                dataType: "json",
                success:function (data) {
                    alert(data.msg);
                    location.reload();
                }
            });

        })


    }

});