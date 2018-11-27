<%-- 
    Document   : Home
    Created on : 12 May, 2017, 12:38:14 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home </title>
    </head>
    <body>
    <html>
        <head>
            <title> admin-panel </title>
            <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
            <link rel="stylesheet" href="style.css">
            <link rel="stylesheet" href="bootstrap.min.css">
            <link rel="stylesheet" href="font-awesome.css">

        </head>

        <body>

            <section class="logo">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1> LOGO </h1>
                        </div>
                    </div>
                </div>
            </section>

            <div id="mySidenav" class="rightsidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <ul class="full-nav">
                    <li><a href="Login.jsp">Log In</a></li>
                    <li><a href="SignUp.jsp">Sign Up</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </div>

            <div class="right">
                <a class="scrl" href="#home-section"> Summarize </a> <span style="font-size:30px;cursor:pointer; float:right; color:#000; margin-right:20px;" onclick="openNav()">&#9776;</span>
            </div>
            <video autoplay loop poster="polina.jpg" id="vid">
                <source src="http://clips.vorwaerts-gmbh.de/big_buck_bunny.webm" type="video/webm">
                <source src="http://www.youtube.com/watch?v=_kclSzbXorA" type="video/mp4">
            </video>


            <div id="mySidenav" class="right<html>

                 <head>
                 <title> admin-panel </title>
                 <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
                 <link rel="stylesheet" href="style.css">
                <link rel="stylesheet" href="bootstrap.min.css">
                <link rel="stylesheet" href="font-awesome.css">
                </head>

                <body>                   
                    <div id="mySidenav" class="rightsidenav">
                        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                        <ul class="full-nav">
                            <li><a href="admin-panel.html">Dashboard</a>
                            </li>
                            <li><a href="#">Log Out</a>
                            </li>
                            <li><a href="#">About Us</a>
                            </li>
                            <li><a href="#">Contact Us</a>
                            </li>
                        </ul>
                    </div>
                    <div class="right">
                        <a class="scrl" href="#home-section"> Summarize </a>
                        <span style="font-size:30px;cursor:pointer; float:right; color:#000; margin-right:20px;" onclick="openNav()">&#9776;</span>
                    </div>

                    <section class="home-section" id="home-section">
                        
                        <section class="logo">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h1> LOGO </h1>
                                    </div>
                                </div>
                            </div>
                        </section>
                        
                    <div style="background-color:#111; color: #f9b332;" >
                        <section class="txt">
                            <div class="container">
                                <div class="row">
                                    <div class="col-g-12 col-md-12 col-sm-12 col-xs-12" style="padding-bottom: 30px">
                                         <label style="background-color: red" id="lbmsg1"></label>
                                        <input type="hidden" id="textpath1" name="textpath1">
                                        <br><textarea rows="15" cols="130" id="tatext" name="tatext" style="color:black"></textarea><br><br>
                                        <input type="text" name="textsize" id="textsize" size="70" style="color:black" placeholder="Enter The % Of Content You Want To Summarize"><br><br>
                                        <input type="button" onclick="check()" value="Summarize" style="width:300px;color:black" >
        
                                    </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>    
                    <footer>
                        <section class="footer">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="ftr-txt">
                                            <p>&copy All Rights Reserved</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </footer>

                    <script>
                            var vid = document.getElementById("bgvid");
                            var pauseButton = document.querySelector("#polina button");

                            if (window.matchMedia('(prefers-reduced-motion)').matches) {
                                vid.removeAttribute("autoplay");
                                vid.pause();
                                pauseButton.innerHTML = "Paused";
                            }

                            function vidFade() {
                                vid.classList.add("stopfade");
                            }

                            vid.addEventListener('ended', function () {
                                // only functional if "loop" is removed 
                                vid.pause();
                                // to capture IE10
                                vidFade();
                            });


                            pauseButton.addEventListener("click", function () {
                                vid.classList.toggle("stopfade");
                                if (vid.paused) {
                                    vid.play();
                                    pauseButton.innerHTML = "Pause";
                                } else {
                                    vid.pause();
                                    pauseButton.innerHTML = "Paused";
                                }
                            })

                            function openNav() {
                                document.getElementById("mySidenav").style.width = "100%";
                            }

                            function closeNav() {
                                document.getElementById("mySidenav").style.width = "0";
                            }


                            function showHeight(element, height) {
                                $("div").text("The height for the " + element + " is " + height + "px.");
                            }
                            $("#getp").click(function () {
                                showHeight("paragraph", $("p").height());
                            });
                            $("#getd").click(function () {
                                showHeight("document", $(document).height());
                            });
                            $("#getw").click(function () {
                                showHeight("window", $(window).height());
                            });


                            $(document).ready(function () {
                                $('a.scrl[href^="#"]').click(function (e) {
                                    e.preventDefault();
                                    var target = this.hash,
                                            $target = $(target);
                                    $('html, body').stop().animate({
                                        'scrollTop': $target.offset().top
                                    }, 1500, 'swing', function () {

                                    });
                                });


                            });
                    </script>
                    <script>
                            var vid = document.getElementById("bgvid");
                            var pauseButton = document.querySelector("#polina button");

                            if (window.matchMedia('(prefers-reduced-motion)').matches) {
                                vid.removeAttribute("autoplay");
                                vid.pause();
                                pauseButton.innerHTML = "Paused";
                            }

                            function vidFade() {
                                vid.classList.add("stopfade");
                            }

                            vid.addEventListener('ended', function () {
                                // only functional if "loop" is removed 
                                vid.pause();
                                // to capture IE10
                                vidFade();
                            });


                            pauseButton.addEventListener("click", function () {
                                vid.classList.toggle("stopfade");
                                if (vid.paused) {
                                    vid.play();
                                    pauseButton.innerHTML = "Pause";
                                } else {
                                    vid.pause();
                                    pauseButton.innerHTML = "Paused";
                                }
                            })

                            function openNav() {
                                document.getElementById("mySidenav").style.width = "100%";
                            }

                            function closeNav() {
                                document.getElementById("mySidenav").style.width = "0";
                            }


                            function showHeight(element, height) {
                                $("div").text("The height for the " + element + " is " + height + "px.");
                            }
                            $("#getp").click(function () {
                                showHeight("paragraph", $("p").height());
                            });
                            $("#getd").click(function () {
                                showHeight("document", $(document).height());
                            });
                            $("#getw").click(function () {
                                showHeight("window", $(window).height());
                            });


                            $(document).ready(function () {
                                $('a.scrl[href^="#"]').click(function (e) {
                                    e.preventDefault();
                                    var target = this.hash,
                                            $target = $(target);
                                    $('html, body').stop().animate({
                                        'scrollTop': $target.offset().top
                                    }, 1500, 'swing', function () {

                                    });
                                }); 
                            });
                        </script>
                        <script>
            function check()
            {
                var str = document.getElementById("tatext").value.trim();
                var size = document.getElementById("textsize").value;
                if (str =="")
                {
                    window.alert("Enter The Text To Be Summarized");
                } else
                {
                    if (size == "")
                    {
                        window.alert("Enter The % Of Content You Want To Summarize.");
                        document.getElementById("textsize").focus();
                    } else
                    {
                        var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function () {
                            if (this.readyState == 4 && this.status == 200) {
                                document.getElementById("textpath1").value = this.responseText;
                                var url1 = "PSOGuest?path=" + this.responseText + "&size=" + size;
                                window.location.href = url1;
                            }
                        };
                        var url = "createfileguest";
                        var param = "str=" + str;
                        xhttp.open("POST", url, true);
                        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                        xhttp.send(param);

                    }
                }
            }
        </script>

                    <!-- js files -->
                    <script src="js/jquery.min.js"></script>
                    <script src="js/bootstrap.min.js"></script>
                </body>
    </html>           
</body>
</html>
