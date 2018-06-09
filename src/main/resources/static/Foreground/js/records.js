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

        var userId = sessionStorage['id'];
        //借阅列表
        $.ajax({
            type:"GET",
            url:"/records/userRecords",
            async:true,
            data:{
                id:userId
            },
            dataType: "json",
            success:function (data) {
                console.info(data);
                if(data.code==="0"){
                    var len = data.data.borrowRecords.length;
                    var temp = "";

                    for(var i=0;i<len;i++){
                        var btn;
                        var borrow = new Date(data.data.borrowRecords[i].borrowTime) ;
                        var should = new Date(data.data.borrowRecords[i].shouldTime);
                        var re;

                        if(data.data.borrowRecords[i].returnTime==0){
                            btn = "<button class='btn btn-info' onclick='backBook("+ data.data.borrowRecords[i].id  +")' >归还</button>"
                            re="";
                        }
                        else{
                            btn = "<button class='btn' disabled>已归还</button>";
                            re = new Date(data.data.borrowRecords[i].returnTime)
                        }

                        temp+="<tr><td>"+ data.data.borrowRecords[i].id +"</td>"+
                            "<td>"+ data.data.borrowRecords[i].bookInfo.bookName +"</td>"+
                            "<td>"+ borrow.toLocaleString() +"</td>"+
                            "<td>"+ should.toLocaleString() +"</td>"+
                            "<td>"+ re.toLocaleString() +"</td>"+
                            "<td>"+ btn +"</td>"+
                            +"</tr>";
                    }



                    $("#records").append(temp);
                }
                else    alert(data.msg);
            }



        });

    }



});

function backBook(id) {
    $.ajax({
        type:"POST",
        url:"/book/backBook",
        async:true,
        data:{
            id:id
        },
        dataType: "json",
        success:function (data) {
          alert(data.msg);
          window.location.reload();
        }
    });


}