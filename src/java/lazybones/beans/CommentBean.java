
package lazybones.beans;


public class CommentBean {
    private int commentid,userid;
    private String comm_date_time,comment,rep_date_time,reply,email;

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getComm_date_time() {
        return comm_date_time;
    }

    public void setComm_date_time(String comm_date_time) {
        this.comm_date_time = comm_date_time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRep_date_time() {
        return rep_date_time;
    }

    public void setRep_date_time(String rep_date_time) {
        this.rep_date_time = rep_date_time;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
