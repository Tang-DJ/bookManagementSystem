$(function () {

    function init() {

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
                if(data.code==="0"){

                }
                else    alert(data.msg);
            }
        });

    }



});