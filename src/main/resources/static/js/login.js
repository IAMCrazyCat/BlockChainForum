function signInButtonPressed() {


        var username = document.getElementById("username").value;
        var password =  document.getElementById("password").value;

        if(username == "")
        {
            $("#loginEmailEmpty").show()
        }
        if(password == "")
        {
            $("#loginPasswordEmpty").show()
        }
        if(username != "" && password != "")
        {
            $.ajax({
                    url:"ConnServlet",
                    data:{
                        username: document.getElementById("email").value,
                        password: document.getElementById("password").value,
                        forwardType: "login"
                    },
                    type: "POST",
                    beforeSend: function () {
                        document.getElementById("backBoxContent").style.display = "none";
                        $("#loadingLogo").show();
                        $("#card").flip(true);
                    },
                    success: function(correctInfo){
                        if(correctInfo == "true")
                        {
                            document.getElementById("checkingText").innerHTML = "Welcome back ! " + username.toString();
                            window.location.href = "index.jsp";
                        }
                        else
                        {
                            $("#card").flip(false, showBackContent);
                            //$("#card").flip(false);

                        }
                    },
                    error:function(request){
                        alert("error");
                    }

                    });

        }
    }