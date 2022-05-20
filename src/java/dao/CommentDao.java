/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Blog;
import entity.Comment;
import entity.User;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gökhan
 */
public class CommentDao extends DBConnection {

    private BlogDao blogDao;
    private UserDao userDao;

    public BlogDao getBlogDao() {
        if(this.blogDao == null){
            blogDao = new BlogDao();
        }
        return blogDao;
    }

    public void setBlogDao(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    public UserDao getUserDao() {
        if(this.userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    
    public Comment findById(int id) {
        Comment c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from comments where id=" + id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = new Comment(rs.getInt("id"), this.userDao.findById(rs.getInt("user_id")), rs.getString("title"), rs.getString("content"), rs.getTimestamp("comments_date"),
                        rs.getInt("blog_score"),
                        rs.getBoolean("status"),
                        this.blogDao.findById(rs.getInt("blog_id")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public void create(Comment c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into comments(user_id,title,content,comments_date,blog_score,status,blog_id) values "
                    + "('" + c.getUser().getId() + "','" + c.getTitle()+ "','" + c.getContent()+ "','" + new Timestamp(System.currentTimeMillis()) + "','" + c.getBlog_score() + "','" + c.getStatus() + "','" + c.getBlog().getId() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Comment c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from comments where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Comment c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update comments set user_id='"+c.getUser().getId()+"'"
                    + ",title='"+ c.getTitle()+"'"
                    + ",content='" + c.getContent()+"'"
                    + ",blog_score='" + c.getBlog_score()+ "'"
                    + ",status='" + c.getStatus()+ "' where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Comment> getList() {
        List<Comment> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from comments";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Blog b = this.getBlogDao().findById(rs.getInt("blog_id"));
                User u = this.getUserDao().findById(rs.getInt("user_id"));
                list.add(new Comment(rs.getInt("id"), u, rs.getString("title"), rs.getString("content"), rs.getTimestamp("comments_date"),
                        rs.getInt("blog_score"),
                        rs.getBoolean("status"),
                        b));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
