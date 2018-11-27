package lazybones.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lazybones.beans.UserBean;
import lazybones.db.DBConnection;

public class SignupServices {
    
    public static boolean addUser(UserBean objbean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into usermaster (email,name,contact,password,gender,type,status,signup) values (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, objbean.getEmail());
            pstmt.setString(2, objbean.getName());
            pstmt.setString(3, objbean.getContact());
            pstmt.setString(4, objbean.getPassword());
            pstmt.setBoolean(5, objbean.isGender());
            pstmt.setString(6, objbean.getType());
            pstmt.setBoolean(7, objbean.isStatus());
            pstmt.setString(8, objbean.getSignup());
            int a = pstmt.executeUpdate();
            if (a > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    
    public static boolean checkEmail(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select userid from usermaster where email=?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                return false;
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
        return true;
    }
    
    public static String returnMobile(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String mobile=null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select contact from usermaster where email=?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                mobile=rs.getString("contact");
            }
            else
            {
                mobile="not registered";
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
        System.out.println(mobile);
        return mobile;
    }
}
