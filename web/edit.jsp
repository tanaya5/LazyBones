<%-- 
    Document   : edit
    Created on : May 9, 2017, 10:02:32 PM
    Author     : DELL
--%>

<%@page import="lazybones.services.ManageProfileServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <jsp:useBean id="objbean" class="lazybones.beans.UserBean" ></jsp:useBean>
        <jsp:setProperty name="objbean" property="*"/>
        <%
            if(session!=null)
            {
                objbean.setUserid((int)session.getAttribute("userid"));
                if(request.getParameter("rbgender").equalsIgnoreCase("female"))
                {
                    objbean.setGender(true);
                }
                else
                {
                    objbean.setGender(false);
                }
                
                if(ManageProfileServices.editProfile(objbean))
                {
        %>
        <jsp:forward page="ViewProfile.jsp?msg=Edit Successful"/>
        <%
            }
            else
            {
        %>
        <jsp:forward page="EditProfile.jsp?msg=Edit Failed"/>
        <%
            }
            }
        %>
    </body>
</html>
