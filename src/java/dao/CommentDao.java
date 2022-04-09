/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Comment;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gökhan
 */
public class CommentDao extends DBConnection{
    public Comment findById(int id){
        Comment c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from comment where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new Comment(rs.getInt("id"),rs.getInt("user_id"),rs.getString("title"),rs.getString("content"),rs.getDate("commnets_date")
                ,rs.getInt("blog_score")
                ,rs.getBoolean("status")
                ,rs.getInt("blog_id"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(Comment c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into comment(id,user_id,title,content,comments_date,blog_score,status,blog_id)) values "
                    + "('"+c.getUser_id()+"','"+c.getTitle()+"','"+c.getContent()+"','"+c.getComments_date()+"','"+c.getBlog_score()+"','"+c.getStatus()+"','"+c.getBlog_id()+"')"
                    
                    ;
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Comment c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from comment where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Comment c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update comment set id='"+c.getId()+"' where user_id="+c.getUser_id()+"' where title="+c.getTitle()
                    +"' where content="+c.getContent()
                    +"' where commnets_date="+c.getComments_date()
                    +"' where blog_score="+c.getBlog_score()
                    +"' where status="+c.getStatus()
                    +"' where blog_id="+c.getBlog_id()
                    
                    
                    ;
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Comment> getList(){
        List<Comment> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from comment";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Comment(rs.getInt("id"),rs.getInt("user_id"),rs.getString("title"),rs.getString("content"),rs.getDate("commnets_date")
                ,rs.getInt("blog_score")
                ,rs.getBoolean("status")
                ,rs.getInt("blog_id")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
