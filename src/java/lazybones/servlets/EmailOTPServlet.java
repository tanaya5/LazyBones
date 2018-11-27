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
import lazybones.email.SendMail;
import lazybones.services.OTPServices;
import lazybones.services.SignupServices;

/**
 *
 * @author DELL
 */
public class EmailOTPServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession s = req.getSession(false);
            if (s != null) {
                String email = (String) s.getAttribute("email");
                if (!(SignupServices.checkEmail(email))) {
                    int otp = OTPServices.otpGenerator();
                    String msg = SendMail.sendMail(email, "Your OTP For Password Recovery Is:" + otp, "Password Recovery");
                    if (msg.equalsIgnoreCase("sent")) {
                        resp.getWriter().write(""+otp);
                    } else {
                        resp.getWriter().write(msg);
                    }
                } else {
                    resp.getWriter().write("Not Registered");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
