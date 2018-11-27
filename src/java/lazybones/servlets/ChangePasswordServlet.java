/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazybones.servlets;

import java.io.IOException;
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
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try
       {
          HttpSession s=req.getSession(false);
          if(s!=null)
          {
              int userid=(int)s.getAttribute("userid");
              String oldpwd=req.getParameter("textoldpassword");
              String newpwd=req.getParameter("textnewpassword");
              String msg=ManageProfileServices.changePassword(oldpwd,newpwd,userid);
              if(msg.equals("Done"))
              {
                  resp.sendRedirect("UserPanel.jsp");
              }
              else
              {
                  resp.sendRedirect("ChangePassword.jsp?msg="+msg);
              }
          }
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); 
    }

    
}
