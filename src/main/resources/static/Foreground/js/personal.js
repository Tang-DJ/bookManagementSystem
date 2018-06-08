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


        var id = sessionStorage['id'];
        //个人信息
        $.ajax({
            type:"GET",
            url:"/user/userDetail",
            data:{
                id:id
            },
            dataType: "json",
            success:function (data) {
                console.info(data);
                if(data.code==="0"){

                    var unixTimestamp = new Date(data.data.userList[0].userInfoModel.time);

                    $("#userId").text(data.data.userList[0].id);
                    $("#userName").text(data.data.userList[0].userName);
                    $("#departments").text(data.data.userList[0].userInfoModel.departments);
                    $("#major").text(data.data.userList[0].userInfoModel.major);
                    $("#phone").text(data.data.userList[0].userInfoModel.phone);
                    $("#email").text(data.data.userList[0].userInfoModel.email);
                    $("#max").text(data.data.userList[0].userInfoModel.max);
                    $("#time").text(unixTimestamp.toLocaleString());
                    $("#lendedNum").text(data.data.userList[0].userInfoModel.lendedNum);

                }
                else    alert(data.msg);
            }
        });


    }




});