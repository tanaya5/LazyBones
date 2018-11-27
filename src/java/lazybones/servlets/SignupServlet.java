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
import lazybones.beans.UserBean;
import lazybones.services.SignupServices;

/**
 *
 * @author DELL
 */
public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserBean objbean = new UserBean();
            objbean.setEmail(req.getParameter("textemail"));
            objbean.setName(req.getParameter("textname"));
            objbean.setPassword(req.getParameter("textpassword"));
            objbean.setContact(req.getParameter("textmobile"));
            if (req.getParameter("rbgender").equalsIgnoreCase("female")) {
                objbean.setGender(true);
            } else {
                objbean.setGender(false);
            }
            objbean.setType("User");
            objbean.setStatus(true);
            objbean.setSignup("Email");
            objbean.setVerified(false);
            
            if(SignupServices.addUser(objbean))
            {
                HttpSession s=req.getSession();
                s.setAttribute("email", req.getParameter("textemail"));
               resp.sendRedirect("VerificationPage.jsp");
            }
            else
            {
                resp.sendRedirect("SignUp.jsp?msg=Signup Failed");
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
