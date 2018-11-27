/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazybones.servlets;

import lazybones.services.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class SaveCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s=req.getSession(false);
        if(s!=null)
        {
            int userid=(int)s.getAttribute("userid");
            String comment=req.getParameter("comment");
            boolean flag=ManageProfileServices.userComment(userid, comment);
            if(flag)
            {
                resp.sendRedirect("UserComment.jsp");
            }
            else
            {
                resp.sendRedirect("UserComment.jsp?msg=Failed");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); 
    }

   
}
