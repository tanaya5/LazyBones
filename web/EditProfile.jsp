<%-- 
    Document   : EditProfile
    Created on : May 9, 2017, 9:39:04 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Profile</title>
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
        <center>
        <%@page import="lazybones.beans.UserBean" %>
        <%@page import="lazybones.services.ManageProfileServices"%>
        <%
            if(session!=null)
            {
                int userid=(int)session.getAttribute("userid");
                UserBean objbean=ManageProfileServices.viewProfile(userid);
        %>
        <form action="edit.jsp" method="" id="form">
            <div style="background-color:#111; color: #f9b332">
            <fieldset>
                <%
                    if(request.getParameter("msg")!=null)
                    {
                       if(request.getParameter("msg").equals("Edit Failed"))
                       {
                %>
                <label style="background-color: red">There Was A Problem In Editing Your Profile...Try Again</label><br><br>
                <%
                       }
                    }
                %>
            <br><br><label><b>Email:</b></label>
            <input type="text" readonly name="email" value="<%= objbean.getEmail() %>"><br><br><br>
            <label><b>Name:</b></label>
            <input type="text" name="name" value="<%= objbean.getName()%>" required></label><br><br><br>
            <label><b>Mobile Number:</b></label>
            <input type="text" name="contact" value="<%= objbean.getContact()%>"></label><br><br><br>
            <label><b>Gender:</b></label>
            <%
                if(objbean.isGender())
                {
            %>
            <input type="radio" name="rbgender" value="Female" checked>Female
            <input type="radio" name="rbgender" value="Male">Male<br><br>
            <%
                }
                else
                {
            %>
            <input type="radio" name="rbgender" value="Female">Female
            <input type="radio" name="rbgender" value="Male" checked>Male<br><br>
            <%
                }
                }
            %>
            <br><br> <input type="submit" value="Save" style="background-color: #f9b332;color: black; width: 200px;"><br><br><br>
        </fieldset>
            </div>
        </form>
        </center>
      </div>
    </body>
</html>
