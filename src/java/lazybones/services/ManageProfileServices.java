package lazybones.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import lazybones.beans.CommentBean;
import lazybones.beans.DocumentBean;
import lazybones.beans.UserBean;
import lazybones.db.DBConnection;

public class ManageProfileServices {

    public static UserBean viewProfile(int userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserBean objbean = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select email,name,contact,gender from usermaster where userid=?");
            pstmt.setInt(1, userid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                objbean = new UserBean();
                objbean.setEmail(rs.getString("email"));
                objbean.setName(rs.getString("name"));
                objbean.setContact(rs.getString("contact"));
                objbean.setGender(rs.getBoolean("gender"));
                objbean.setUserid(userid);
                return objbean;
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

    public static boolean editProfile(UserBean objbean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update usermaster set name=?,contact=?,gender=? where userid=?");
            pstmt.setString(1, objbean.getName());
            pstmt.setString(2, objbean.getContact());
            pstmt.setBoolean(3, objbean.isGender());
            pstmt.setInt(4, objbean.getUserid());
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

    public static boolean likeDislike(int userid, String like_dislike) {
        Connection conn = null;
        PreparedStatement pstmt = null, pstmt1 = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select like_dislike from usermaster where userid=?");
            pstmt.setInt(1, userid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String ld = rs.getString("like_dislike");
                pstmt1 = conn.prepareStatement("update usermaster set like_dislike=? where userid=?");
                if (ld == null) {
                    pstmt1.setString(1, like_dislike);
                } else if (ld.equalsIgnoreCase("like") && like_dislike.equalsIgnoreCase("like")) {
                    pstmt1.setString(1, null);
                } else if (ld.equalsIgnoreCase("dislike") && like_dislike.equalsIgnoreCase("dislike")) {
                    pstmt1.setString(1, null);
                } else {
                    pstmt1.setString(1, like_dislike);
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

    public static boolean userComment(int userid, String comment) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            System.out.println(comment);
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into comments (userid,comm_date_time,comment) values (?,?,?)");
            pstmt.setInt(1, userid);
            pstmt.setString(2, getCurrentDateTime());
            pstmt.setString(3, comment);
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

    public static boolean adminReply(int commentid, String reply) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update comments set rep_date_time=?, reply=? where commentid=?");
            pstmt.setString(1, getCurrentDateTime());
            pstmt.setString(2, reply);
            pstmt.setInt(3, commentid);
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

    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d = new Date();
        String str = sdf.format(d);
        return str;
    }
    
    public static int addLoginTime(int userid)
    {
        Connection conn = null;
        PreparedStatement pstmt=null;
        ResultSet rs = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into activitymaster(userid,logintime) values (?,?)");
            pstmt.setInt(1,userid);
            pstmt.setString(2,getCurrentDateTime());
            int a = pstmt.executeUpdate();
            if(a>0) {
                pstmt=conn.prepareStatement("select max(activityid) from activitymaster where userid=?");
                pstmt.setInt(1, userid);
                rs=pstmt.executeQuery();
                if(rs.next())
                return rs.getInt("max(activityid)");
            }

        } catch (Exception e) {
            System.out.println("addLoginTime " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return 0;
    }
    
    public static boolean updateLogoutTime(int activityid)
    {
      Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update activitymaster set logouttime=? where activityid=?");
            pstmt.setString(1,getCurrentDateTime());
            pstmt.setInt(2, activityid);
            int a= pstmt.executeUpdate();
            if(a>0) {
                
                 return true;
            }

        } catch (Exception e) {
            System.out.println("updateLogoutTime " + e);
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

    public static boolean resetPassword(String email, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("update usermaster set password=? where email=?");
            pstmt.setString(1,pwd);
            pstmt.setString(2,email );
            int a=pstmt.executeUpdate();
            if(a>0)
            {
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
    
    public static String changePassword(String oldpwd, String newpwd,int userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String msg=null;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select password from usermaster where userid=?");
            pstmt.setInt(1,userid);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                if(rs.getString("password").equals(oldpwd))
                {
                    pstmt=conn.prepareStatement("update usermaster set password=? where userid=?");
                    pstmt.setString(1, newpwd);
                    pstmt.setInt(2, userid);
                    int a=pstmt.executeUpdate();
                    if(a>0)
                    {
                        msg="Done";
                        return msg;
                    }
                }
                else
                {
                    msg="Missmatch";
                    return msg;
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
        msg="Error";
        return msg;
    }
    
    public static UserBean getDashboard(int userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserBean objbean = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select email,name,type,like_dislike from usermaster where userid=?");
            pstmt.setInt(1, userid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                objbean = new UserBean();
                objbean.setEmail(rs.getString("email"));
                objbean.setName(rs.getString("name"));
                objbean.setType(rs.getString("type"));
                objbean.setLike_dislike(rs.getString("like_dislike"));
                return objbean;
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
    public static ArrayList<CommentBean> getUserComments(int userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<CommentBean> al = null;
        CommentBean objbean = null;
        try {
            conn = DBConnection.connect();
            al=new ArrayList<CommentBean>();
            pstmt = conn.prepareStatement("select commentid,comm_date_time,comment,rep_date_time,reply,email from comments,usermaster where comments.userid=usermaster.userid and comments.userid=?");
            pstmt.setInt(1, userid);
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
    
    public static boolean saveDocument(DocumentBean objbean)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into document(name,date_time,type,userid) values(?,?,?,?)");
            pstmt.setString(1,objbean.getName());
            pstmt.setString(2,getCurrentDateTime());
            pstmt.setString(3,objbean.getType());
            pstmt.setInt(4,objbean.getUserid());
            int a = pstmt.executeUpdate();
            if (a>0) {
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
    
    public static ArrayList<DocumentBean> getDocuments(int userid,int pg)
    {
       Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<DocumentBean> al = null;
        DocumentBean objbean = null;
        int idx = 0;
        try {
            idx = (pg - 1) * 10;
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select userid,name,date_time,type,documentid from document limit ?,10");
            pstmt.setInt(1, idx);
            rs = pstmt.executeQuery();
            al = new ArrayList<DocumentBean>();
            while (rs.next()) {
                objbean = new DocumentBean();
                objbean.setUserid(rs.getInt("userid"));
                objbean.setName(rs.getString("name"));
                objbean.setDate_time(rs.getString("date_time"));
                objbean.setType(rs.getString("type"));
                objbean.setDocumentid(rs.getInt("documentid"));
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
    
    public static int numberOfDocuments(int userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int num=-1;
        try {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select count(*) as num from document where userid=?");
            pstmt.setInt(1, userid);
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
}
