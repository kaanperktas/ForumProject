
package entity;

import java.util.Date;


public class Comment {
    private int id;
    private int user_id;
    private String title;
    private String content;
    private Date comments_date;
    private int blog_score;
    private Boolean status;
    private int blog_id;

    public Comment() {
    }

    public Comment(int id, int user_id, String title, String content, Date comments_date, int blog_score, Boolean status, int blog_id) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.comments_date = comments_date;
        this.blog_score = blog_score;
        this.status = status;
        this.blog_id = blog_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getComments_date() {
        return comments_date;
    }

    public void setComments_date(Date comments_date) {
        this.comments_date = comments_date;
    }

    public int getBlog_score() {
        return blog_score;
    }

    public void setBlog_score(int blog_score) {
        this.blog_score = blog_score;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }
    
}
