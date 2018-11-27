/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazybones.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lazybones.services.ManageProfileServices;

/**
 *
 * @author DELL
 */
public class SaveReplyServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s=req.getSession(false);
        if(s!=null)
        {   System.out.println(req.getParameter("commentid"));
            String reply=req.getParameter("reply");
            int commentid=Integer.parseInt(req.getParameter("commentid"));
            boolean flag=ManageProfileServices.adminReply(commentid, reply);
            if(flag)
            {
                resp.sendRedirect("Comments.jsp");
            }
            else
            {
                resp.sendRedirect("Comments.jsp?msg=Failed");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); 
    }

}
