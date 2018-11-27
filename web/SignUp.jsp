<%-- 
    Document   : SignUp
    Created on : 24 Apr, 2017, 4:46:28 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up Page</title>
         <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome.css">

    <link rel="stylesheet" href="bootstrap.min.css">

    <link rel="stylesheet" href="style.css">
        <meta name="google-signin-client_id" content="217480766842-v9hseakrkh9ncio2f374jhqdfvc1i9b8.apps.googleusercontent.com">
        <script src="https://apis.google.com/js/platform.js" async defer></script> 
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
         <span style="font-size:30px;cursor:pointer; float:right; color:white; margin-right:20px;" onclick="openNav()">&#9776;</span>
    
            <div id="mySidenav" class="rightsidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <ul class="full-nav">
                        <li><a href="Guest.jsp">Home</a></li>
                        <li><a href="Login.jsp">Login </a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
            </div>
        <div  >
            <center>
                <form action="signup" method="post" id="form">
                    <div style="background-color:#111; color: #f9b332;">
                        <fieldset>
                            <label style="background-color: red" id="lbpopup"></label>
                            <%if (request.getParameter("msg") != null) {
                                    out.println("<label style='background-color:red'>There Was An Error Signing Up...Try Again</label>");
                                }
                            %>

                            <div><b><h2>Signup with LAZYBONES</h2></b></div><br>
                            <div> <h5>USING</h5> </div><br>
                            <div> <div class="g-signin2" data-onsuccess="onSignIn"></div>
                                <label> OR </label>
                                <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                                </fb:login-button></div>
                            <div> <h5>-OR USING EMAIL-</h5> </div>
                            <div > &nbsp;<input style="width: 240px;" type="email" name="textemail" id="textemail" placeholder="Your Email Address" required onblur="checkEmail()" ><br>
                                <label id="lbmsg" style="color:red"></label>
                                <br> 
                                <input style="width: 240px;" type="text" name="textname" id="textname" placeholder="Name" required><br><br>
                                <input style="width: 240px;" type="password" name="textpassword" id="textpassword" placeholder="Choose Password" required><br><br>
                                <input  style="width: 240px;" type="text" name="textmobile" id="textmobile" placeholder="Mobile Number (with country code)" required><br> <br>

                                <label>I'm a</label>
                                <input type="radio" name="rbgender" value="Female" checked>Female
                                <input type="radio" name="rbgender" value="Male">Male<br><br>
                                <input type="submit" value="REGISTER" style="background-color: #f9b332;color: black; width: 240px"><br><br><br></div>
                            <div> 
                                <label> Already have an account?</label>
                                <a href="Login.jsp">Login</a></div><br>
                        </fieldset>
                    </div>
                </form>
            </center>
        </div>

        <script>
            function checkEmail()
            {
                var email = document.getElementById("textemail").value;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        if (this.responseText == "false")
                        {
                            document.getElementById("lbmsg").innerHTML = "Email is already registered!!";
                            document.getElementById("textemail").focus();
                        } else
                        {
                            document.getElementById("lbmsg").innerHTML = "";
                        }
                    }
                };
                var url = "checkemail?email=" + email;
                xhttp.open("GET", url, true);
                xhttp.send();
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
                        if (this.readyState == 4 && this.status == 200) {
                            if (this.responseText == "false")
                            {
                                document.getElementById("lbpopup").innerHTML = "There Was An Error Signing Up....Try Again";
                            } else
                            {
                                window.location.href = "VerificationPage.jsp?email="+response.email;
                            }
                        }
                    };
                    var url = "facebooksignup";
                    var params = "email=" + response.email + "&id=" + response.id + "&name=" + response.name;
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
                        if (this.readyState == 4 && this.status == 200) {
                            if (this.responseText == "false")
                            {
                                document.getElementById("lbpopup").innerHTML = "There Was An Error Signing Up....Try Again";
                            } else if(this.responseText == "true")
                            {
                                window.location.href="VerificationPage.jsp?email="+profile.getEmail();
                            }
                        }
                    };
                    var url = "googlesignup";
                    var params = "email=" + profile.getEmail() + "&id=" + profile.getId() + "&name=" + profile.getName();
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
