
package entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;


public class Comment {
    private int id;
    private User user;
    private String title;
    private String content;
    private Timestamp comments_date;
    private int blog_score;
    private Boolean status;
    private Blog blog;

    public Comment(int id, User user, String title, String content, Timestamp comments_date, int blog_score, Boolean status, Blog blog) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.comments_date = comments_date;
        this.blog_score = blog_score;
        this.status = status;
        this.blog = blog;
    }

    public Timestamp getComments_date() {
        return comments_date;
    }

    public void setComments_date(Timestamp comments_date) {
        this.comments_date = comments_date;
    }

   

    public Comment() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    
    
}
