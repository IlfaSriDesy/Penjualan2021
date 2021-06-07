$(document).ready(function() {

    $("form").submit(function(event){

        event.preventDefault();

        const body = {
            "username" : $("input[name=username]").val(),
            "password" : $("input[name=password]").val()
        }

        $.post({
            url: "/rest-login/do-login",
            contentType: "application/json",
            data : JSON.stringify(body),
            success: function(response){
                window.location.replace("/home")

            },
            error : function (response){
                let responseJSON = response.responseJSON;

                let notifSuccess = $("#notif-success");
                let notifFail = $("#notif-fail");

                notifFail.html(responseJSON.message);

                notifFail.show();
                notifSuccess.hide();

            }
        });

    });

});