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
import lazybones.beans.UserBean;
import lazybones.services.LoginServices;
import lazybones.services.ManageProfileServices;

/**
 *
 * @author DELL
 */
public class FacebookLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pwd = req.getParameter("id");
        UserBean objbean = LoginServices.authenticateUser(email, pwd);
        if (objbean != null) {
            if (objbean.isStatus()) {
                if (objbean.getSignup().equalsIgnoreCase("Facebook")) {
                    if (objbean.isVerified()) {
                        int activityid = ManageProfileServices.addLoginTime(objbean.getUserid());
                        HttpSession s = req.getSession();
                        s.setAttribute("userid", objbean.getUserid());
                        s.setAttribute("email", email);
                        s.setAttribute("type", objbean.getType());
                        s.setAttribute("activityid", activityid);
                        resp.getWriter().write(objbean.getType());
                     /* if (objbean.getType().equalsIgnoreCase("User")) {
                            RequestDispatcher rd = req.getRequestDispatcher("UserPanel.jsp");
                            rd.forward(req, resp);
                        } else {
                            RequestDispatcher rd = req.getRequestDispatcher("AdminPanel.jsp");
                            rd.forward(req, resp);
                        }*/
                    }
                    else
                    {
                        resp.getWriter().write(email);
                        //resp.sendRedirect("VerificationPage.jsp?email="+email);
                    }

                } else {
                    resp.getWriter().write("Error");
                    //resp.sendRedirect("Login.jsp?msg=Error");
                }

            } else {
                resp.getWriter().write("Inactive User");
                //resp.sendRedirect("Login.jsp?msg=Inactive User");
            }
        } else {
            resp.getWriter().write("Login Unsuccessful");
            //resp.sendRedirect("Login.jsp?msg=Login Unsuccessful");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
