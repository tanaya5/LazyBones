<%-- 
    Document   : Summarize
    Created on : May 12, 2017, 10:56:03 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Summarize </title>
        <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome.css">

    <link rel="stylesheet" href="bootstrap.min.css">

    <link rel="stylesheet" href="style.css">
    </head>

    <body style="background-color: #292626;">
        <span style="font-size:30px;cursor:pointer; float:right; color:white; margin-right:20px;" onclick="openNav()">&#9776;</span>
            <div id="mySidenav" class="rightsidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <ul class="full-nav">
                        <li><a href="UserPanel.jsp">Dashboard</a></li>
                        <li><a href="logout">Log Out</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
            </div>
        <div style="color: white;padding-top: 20px;padding-left: 110px;padding-right: 110px">
        <%
            if (request.getParameter("msg") != null) {
        %>
        <label style="background-color: red" id="lbmsg">File Uploaded Successfully</label>
        <input type="hidden" id="textpath" name="textpath" value="<%= request.getParameter("msg")%>">
        <%
            }
        %>
        <label style="background-color: red" id="lbmsg1"></label>
        <input type="hidden" id="textpath1" name="textpath1">
        <br><textarea rows="15" cols="130" id="tatext" name="tatext" style="color:black"></textarea><br><br>
        <label>OR</label><br>
        <label>Select A File To Upload:</label><br>
        <form action="upload" method="post" enctype="multipart/form-data">
            <input type="file" id="textfile" name="textfile" accept=".doc, .docx, .txt" size="80"><br>
            <input type="submit"style="color: black" value="Upload File">
        </form>
        <br>
        <input type="text" name="textsize" id="textsize" size="70" style="color:black" placeholder="Enter The % Of Content You Want To Summarize"><br><br>
        <input type="button" onclick="check()" value="Summarize" style="width:300px;color:black">
        </div>
        <script>
            function check()
            {
                var str = document.getElementById("tatext").value.trim();
                var size = document.getElementById("textsize").value;
                if (size == "")
                {
                    window.alert("Enter The % Of Content You Want To Summarize.");
                    document.getElementById("textsize").focus();
                } else
                {
                    if (str == "")
                    {
                        var path = document.getElementById("textpath").value;
                        if (path != "")
                        {
                            var url = "PSO?path=" + path+"&size="+size;
                            window.location.href = url;
                        } else if (path = "")
                        {
                            window.alert("Either Enter Text Or Upload A File");
                        }
                    } else
                    {
                        var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function () {
                            if (this.readyState == 4 && this.status == 200) {
                                document.getElementById("textpath1").value = this.responseText;
                                document.getElementById("lbmsg1").innerHTML = "File Uploaded Successfully";
                                var url1 = "PSO?path=" + this.responseText+"&size="+size;
                                window.location.href = url1;
                            }
                        };
                        var url = "createfile";
                        var param = "str=" + str;
                        xhttp.open("POST", url, true);
                        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                        xhttp.send(param);

                    }
                }


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
