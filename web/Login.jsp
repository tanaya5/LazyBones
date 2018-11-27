<%--
    Document   : Login
    Created on : 24 Apr, 2017, 2:40:38 PM
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="google-signin-client_id" content="217480766842-v9hseakrkh9ncio2f374jhqdfvc1i9b8.apps.googleusercontent.com">
        <title>Login Page</title>
         <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome.css">

    <link rel="stylesheet" href="bootstrap.min.css">

    <link rel="stylesheet" href="style.css">
         <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
            <link rel="stylesheet" href="style.css">
            <link rel="stylesheet" href="bootstrap.min.css">
            <link rel="stylesheet" href="font-awesome.css">
        <style>
            
            #form
            {
                width: 500px;
            }
        </style>
    </head>
    <body style="background-color: #292626"> 
        <section class="logo">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1> LOGO </h1>
                        </div>
                    </div>
                </div>
            </section>
        <div  >
             <span style="font-size:30px;cursor:pointer; float:right; color:white; margin-right:20px;" onclick="openNav()">&#9776;</span>
    
            <div id="mySidenav" class="rightsidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <ul class="full-nav">
                        <li><a href="Guest.jsp">Home</a></li>
                        <li><a href="SignUp.jsp">SignUp</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
            </div>
         

        <script src="https://apis.google.com/js/platform.js" async defer></script>
        
            <center>
            <form action="login" method="post" id="form">
                <div class="form" style="background-color:#111; color: #f9b332">
                <fieldset >
                    <%if (request.getParameter("msg") != null) {
                            if (request.getParameter("msg").equals("Inactive User")) {
                                out.println("<label style='background-color:red'> !  The User Is Blocked By The Admin</label>");
                            } else if (request.getParameter("msg").equals("Login Unsuccessful")) {
                                out.println("<label style='background-color:red'> !  The Email Or Password You Entered Is Incorrect</label>");
                            } else if (request.getParameter("msg").equals("Reset Password Successful")) {
                                out.println("<label style='background-color:red'> !  Your Password Has Been Reset Successfully</label>");
                            } else if (request.getParameter("msg").equals("Reset Password Failed")) {
                                out.println("<label style='background-color:red'> !  There Was An Error While Resetting The Password...Try Again</label>");
                            }
                             else if (request.getParameter("msg").equals("Error")) {
                                out.println("<label style='background-color:red'> !  There Was An Error While Logging In....Try Again</label>");
                            }
                        }
                    else
                    {
                        if(session!=null)
                        {
                            session.invalidate();
                        }
                    }
                    %>

                    <div><b><h2>Login to LAZYBONES</h2><b></div><br>
                    <div><h5>USING</h5></div><br>
                    <div><div class="g-signin2" data-onsuccess="onSignIn"></div> <br>
                        <label> OR </label><br>
                        <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                        </fb:login-button></div>
                    <div> <h5>-OR USING EMAIL-</h5> </div>
                    <div> <input type="email" name="textemail" id="textemail" placeholder="Your Email Address" required><br> <br>
                        <input type="password" name="textpassword" id="textpassword" placeholder="Enter Password" required><br> <br><br>
                        <input type="submit" value="LOGIN" style="background-color: #f9b332;color: black;width: 180px"><br><br><br></div>
                    <div> <a href="javascript:recoverPassword()" >Recover Password</a>
                        <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; New to LAZYBONES?</label>
                        <a href="SignUp.jsp" >Create Account</a></div><br><br><br>
                </fieldset>
                    </div>
            </form>
            </center>
        </div>

        <script type="text/javascript">
            function recoverPassword()
            {
                var email = document.getElementById("textemail").value.trim();
                if (email === "")
                {
                    window.alert("Enter Your Email");
                    document.getElementById("textemail").focus();
                } else
                {
                    var url = "RecoverPassword.jsp?email=" + email;
                    window.location.href = url;
                }
            }
            
            function statusChangeCallback(response) {
                console.log('statusChangeCallback');
                console.log(response);

                if (response.status === 'connected') {

                    testAPI();
                } else {

                    document.getElementById('status').innerHTML = 'Please log ' +
                            'into this app.';
                }
            }


            function checkLoginState() {
                FB.getLoginStatus(function (response) {
                    statusChangeCallback(response);
                });
            }

            window.fbAsyncInit = function () {
                FB.init({
                    appId: '1456542897700174',
                    cookie: true,

                    xfbml: true,
                    version: 'v2.8'
                });



                FB.getLoginStatus(function (response) {
                    statusChangeCallback(response);
                });

            };


            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));


            function testAPI() {
                console.log('Welcome!  Fetching your information.... ');
                FB.api('/me', {fields: 'name, email'}, function (response) {
                    /*console.log('Successful login for: ' + response.name);
                     document.getElementById('status').innerHTML =
                     'Thanks for logging in, ' + response.name;
                     document.getElementById('eid').innerHTML =
                     'Your ID is, '+response.id;
                     document.getElementById('em').innerHTML =
                     'Your email is, ' +response.email;*/

                    var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function () {
                        if (this.readyState === 4 && this.status === 200) {
                            if (this.responseText === "User")
                            {
                                window.location.href="UserPanel.jsp";
                            } else if(this.responseText === "Administrator")
                            {
                                window.location.href="AdminPanel.jsp";
                            }
                            else if(this.responseText === "Error")
                            {
                                window.location.href="Login.jsp?msg=Error";
                            }
                            else if(this.responseText === "Inactive User")
                            {
                                window.location.href="Login.jsp?msg=Inactive User";
                            }
                            else if(this.responseText === "Login Unsuccessful")
                            {
                                window.location.href="Login.jsp?msg=Login Unsuccessful";
                            }
                            else
                            {
                                window.location.href="VerificationPage.jsp?email="+this.responseText;
                            }
                        }
                    };
                    var url = "facebooklogin";
                    var params = "email=" + response.email + "&id=" + response.id;
                    xhttp.open("POST", url, true);
                    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    xhttp.send(params);
                });
            }
            
            function onSignIn(googleUser) {
                var profile = googleUser.getBasicProfile();
                /*document.write('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
                document.write('Name: ' + profile.getName());
                document.write('Image URL: ' + profile.getImageUrl());
                document.write('Email: ' + profile.getEmail()+'<br>');*/ // This is null if the 'email' scope is not present.
               
               var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function () {
                        if (this.readyState === 4 && this.status === 200) {
                            if (this.responseText === "User")
                            {
                                window.location.href="UserPanel.jsp";
                            } else if(this.responseText === "Administrator")
                            {
                                window.location.href="AdminPanel.jsp";
                            }
                            else if(this.responseText === "Error")
                            {
                                window.location.href="Login.jsp?msg=Error";
                            }
                            else if(this.responseText === "Inactive User")
                            {
                                window.location.href="Login.jsp?msg=Inactive User";
                            }
                            else if(this.responseText === "Login Unsuccessful")
                            {
                                window.location.href="Login.jsp?msg=Login Unsuccessful";
                            }
                            else
                            {
                                window.location.href="VerificationPage.jsp?email="+this.responseText;
                            }
                        }
                    };
                    var url = "googlelogin";
                    var params = "email=" + profile.getEmail() + "&id=" + profile.getId();
                    xhttp.open("POST", url, true);
                    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    xhttp.send(params);
            }

            
            function signOut() {
                var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                    document.write('User signed out.');
                });
            }
        </script>
         <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "100%";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
    </script>
    </body>
</html>
