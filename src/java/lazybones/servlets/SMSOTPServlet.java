/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazybones.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.*;
import java.security.*;
import java.net.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lazybones.services.OTPServices;
import lazybones.services.SignupServices;

/**
 *
 * @author DELL
 */
public class SMSOTPServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession s = req.getSession(false);
            if (s != null) {
                String email = (String) s.getAttribute("email");
                String phnum = SignupServices.returnMobile(email);
                if (phnum == null) {
                    resp.getWriter().write("not provided");
                } else if (phnum.equals("not registered")) {
                    resp.getWriter().write(phnum);
                } else {
                    int otp = OTPServices.otpGenerator();
                    String message = "Your%20OTP%20IS:%20"+otp;
                    try {
                        URL myurl = new URL("http://api.mvaayoo.com/mvaayooapi/MessageCompose?user=bhavpreetkaur_7@yahoo.com:bhavpreet&senderID=TEST%20SMS&receipientno="+phnum+"&dcs=0&msgtxt="+message+"");
                        BufferedReader in = new BufferedReader(new InputStreamReader(myurl.openStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println(inputLine);
                        }

                        in.close();
                    } catch (Exception e) {
                        System.out.println("error" + e);
                    }
                    resp.getWriter().write(""+otp);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
