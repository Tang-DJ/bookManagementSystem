$(function () {

    function init() {

        $.ajax({
            type:"post",
            url:"/book/bookList",
            async:true,
            dataType: "json",
            success:function (data) {
               console.info(data);

            }
        });


    }




});