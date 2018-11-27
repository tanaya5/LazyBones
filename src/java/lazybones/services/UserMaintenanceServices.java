package lazybones.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lazybones.beans.ActivityBean;
import lazybones.beans.CommentBean;
import lazybones.beans.UserBean;
import lazybones.db.DBConnection;

public class UserMaintenanceServices {

    public static boolean addGuest() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        int num=0;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select number from guests");
            rs=pstmt.executeQuery();
            if(rs.next())
            {
               num=rs.getInt("number");
               num++;
               pstmt=conn.prepareStatement("update guests set number=?");
               pstmt.setInt(1, num);
               int a=pstmt.executeUpdate();
               if(a>0)
               {
                   return true;
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
        return false;
    }
    
    public static ArrayList<UserBean> getAllUsers(int pg) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserBean> al = null;
        UserBean objbean = null;
        int idx = 0;
        try {
            idx = (pg - 1) * 10;
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select userid,email,name,contact,gender,type,status,signup from usermaster limit ?,10");
            pstmt.setInt(1, idx);
            rs = pstmt.executeQuery();
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                objbean = new UserBean();
                objbean.setUserid(rs.getInt("userid"));
                objbean.setEmail(rs.getString("email"));
                objbean.setName(rs.getString("name"));
                objbean.setContact(rs.getString("contact"));
                objbean.setGender(rs.getBoolean("gender"));
                objbean.setType(rs.getString("type"));
                objbean.setStatus(rs.getBoolean("status"));
                objbean.setSignup(rs.getString("signup"));
                al.add(objbean);
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
        return al;
    }

    public static boolean changeStatus(int userid) {
        Connection conn = null;
        PreparedStatement pstmt = null, pstmt1 = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select status from usermaster where userid=?");
            pstmt.setInt(1, userid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                boolean status = rs.getBoolean("status");
                pstmt1 = conn.prepareStatement("update usermaster set status=? where userid=?");
                if (status) {
                    pstmt1.setBoolean(1, false);
                } else {
                    pstmt1.setBoolean(1, true);
                }
                pstmt1.setInt(2, userid);
                int a = pstmt1.executeUpdate();
                if (a > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                pstmt1.close();
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    public static boolean changeUserType(int userid) {
        Connection conn = null;
        PreparedStatement pstmt = null, pstmt1 = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select type from usermaster where userid=?");
            pstmt.setInt(1, userid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String type = rs.getString("type");
                pstmt1 = conn.prepareStatement("update usermaster set type=? where userid=?");
                if (type.equalsIgnoreCase("Administrator")) {
                    pstmt1.setString(1,"User");
                } else {
                    pstmt1.setString(1,"Administrator");
                }
                pstmt1.setInt(2, userid);
                int a = pstmt1.executeUpdate();
                if (a > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                pstmt1.close();
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public static boolean editUser(UserBean objbean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update usermaster set name=?,contact=?,gender=?,type=? where userid=?");
            pstmt.setString(1, objbean.getName());
            pstmt.setString(2, objbean.getContact());
            pstmt.setBoolean(3, objbean.isGender());
            pstmt.setString(4, objbean.getType());
            pstmt.setInt(5, objbean.getUserid());
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

    public static ArrayList<CommentBean> getAllComments() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<CommentBean> al = null;
        CommentBean objbean = null;
        try {
            conn = DBConnection.connect();
            al=new ArrayList<CommentBean>();
            pstmt = conn.prepareStatement("select commentid,comm_date_time,comment,rep_date_time,reply,email from comments,usermaster where comments.userid=usermaster.userid");
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                objbean=new CommentBean();
                objbean.setCommentid(rs.getInt("commentid"));
                objbean.setComm_date_time(rs.getString("comm_date_time"));
                objbean.setComment(rs.getString("comment"));
                objbean.setRep_date_time(rs.getString("rep_date_time"));
                objbean.setReply(rs.getString("reply"));
                objbean.setEmail(rs.getString("email"));
                al.add(objbean);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return al;
    }

    public static int numberOfLikes() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int likes=-1;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select count(*) as likes from usermaster where like_dislike=?");
            pstmt.setString(1, "like");
            rs=pstmt.executeQuery();
            if(rs.next())
            {
               likes=rs.getInt("likes");
               return likes;
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
        return likes;
    }
    
    public static int numberOfDislikes() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int dislikes=-1;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select count(*) as dislikes from usermaster where like_dislike=?");
            pstmt.setString(1, "dislike");
            rs=pstmt.executeQuery();
            if(rs.next())
            {
               dislikes=rs.getInt("dislikes");
               return dislikes;
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
        return dislikes;
    }
    
    public static int numberOfRegisteredUsers() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int num=-1;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select count(*) as num from usermaster");
            rs=pstmt.executeQuery();
            if(rs.next())
            {
               num=rs.getInt("num");
               return num;
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
        return num;
    }
    
    public static int numberOfGuestUsers() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int num=-1;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select number from guests");
            rs=pstmt.executeQuery();
            if(rs.next())
            {
               num=rs.getInt("number");
               return num;
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
        return num;
    }
    
  public static int numberOfActiveUsers() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int num=-1;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select count(*) as num from activitymaster where logintime is not null and logouttime is null");
            rs=pstmt.executeQuery();
            if(rs.next())
            {
               num=rs.getInt("num");
               return num;
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
        return num;
    } 
  
  public static int numberOfActivity() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int num=-1;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select count(*) as num from activitymaster");
            rs=pstmt.executeQuery();
            if(rs.next())
            {
               num=rs.getInt("num");
               return num;
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
        return num;
    }
  
  public static ArrayList<ActivityBean> getAllActivity(int pg) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ActivityBean> al = null;
        ActivityBean objbean = null;
        int idx = 0;
        try {
            idx = (pg - 1) * 10;
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select activitymaster.userid,email,name,logintime,logouttime from usermaster,activitymaster where activitymaster.userid=usermaster.userid order by activityid limit ?,10");
            pstmt.setInt(1, idx);
            rs = pstmt.executeQuery();
            al = new ArrayList<ActivityBean>();
            while (rs.next()) {
                objbean = new ActivityBean();
                objbean.setUserid(rs.getInt("userid"));
                objbean.setEmail(rs.getString("email"));
                objbean.setName(rs.getString("name"));
                objbean.setLogintime(rs.getString("logintime"));
                objbean.setLogouttime(rs.getString("logouttime"));
                al.add(objbean);
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
        return al;
    }
  
  public static boolean verifyAccount(String email)
  {
      Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update usermaster set verified=? where email=?");
            pstmt.setBoolean(1,true);
            pstmt.setString(2,email);
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
}
