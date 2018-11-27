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
import lazybones.beans.UserBean;
import lazybones.services.SignupServices;

/**
 *
 * @author DELL
 */
public class GoogleSignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserBean objbean = new UserBean();
            objbean.setEmail(req.getParameter("email"));
            objbean.setName(req.getParameter("name"));
            objbean.setPassword(req.getParameter("id"));
            objbean.setType("User");
            objbean.setStatus(true);
            objbean.setSignup("Google");
            
            if(SignupServices.addUser(objbean))
            {
               resp.getWriter().write("true");
            }
            else
            {
                resp.getWriter().write("false");
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
