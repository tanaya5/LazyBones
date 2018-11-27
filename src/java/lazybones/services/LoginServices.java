
package lazybones.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lazybones.beans.UserBean;
import lazybones.db.DBConnection;


public class LoginServices {
    
    public static UserBean authenticateUser(String email, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserBean objbean = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select userid,password,type,status,signup,verified from usermaster where email=?");
            pstmt.setString(1,email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (pwd.equals(rs.getString("password"))) {
                    objbean=new UserBean();
                    objbean.setUserid(rs.getInt("userid"));
                    objbean.setType(rs.getString("type"));
                    objbean.setStatus(rs.getBoolean("status"));
                    objbean.setSignup(rs.getString("signup"));
                    objbean.setVerified(rs.getBoolean("verified"));
                    return objbean;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return objbean;
    }
    
   /* public static String[] forgotPassword(String email) {               //Add mobile as well
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String a[] = new String[2];
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select password,email from usermaster where email=?");
            pstmt.setString(1, email);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                a[0]=rs.getString("password");
                a[1]=rs.getString("email");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return a;
    }*/
}
