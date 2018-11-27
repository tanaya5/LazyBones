<%-- 
    Document   : ViewProfile
    Created on : May 9, 2017, 7:57:44 PM
  
--%>

<%@page import="lazybones.services.ManageProfileServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <div >
            <center>
        <%@page import="lazybones.beans.UserBean" %>
        <%
            if(session!=null)
            {
                int userid=(int)session.getAttribute("userid");
                UserBean objbean=ManageProfileServices.viewProfile(userid);
        %>
        <fieldset style="background-color:#111; color: #f9b332;" id="form" >
            <%
                    if(request.getParameter("msg")!=null)
                    {
                       if(request.getParameter("msg").equals("Edit Successful"))
                       {
                %>
                <label style="background-color: red">Your Profile Was Edited Successfully</label><br><br>
                <%
                       }
                    }
                %>
           <br><br> <label><b>Email:</b></label>
            <label> <%= objbean.getEmail()%></label><br><br><br>
            <label><b>Name:</b></label>
            <label><%= objbean.getName()%></label><br><br><br>
            <label><b>Mobile Number:</b></label>
            <label><%= objbean.getContact()%></label><br><br><br>
            <label><b>Gender:</b></label>
            <%
                if(objbean.isGender())
                {
            %>
            <label>Female</label><br><br>
            <%
                }
                else
                {
            %>
            <label>Male</label><br><br>
            <%
                }
                }
            %>
            <br><button onclick="location.href='UserPanel.jsp'" style="background-color: #f9b332;color: black">Back</button>
       <br><br><br> </fieldset>
            </center>
            </div>
    </body>
</html>
