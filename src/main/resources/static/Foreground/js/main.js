$(function () {
    init();
    function init() {

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

        $.ajax({
            type:"GET",
            url:"/book/simBookListOrderByCome",
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
                    $("#latest").append(temp);
                }
                else    alert(data.msg);

            }
        });

    }




});