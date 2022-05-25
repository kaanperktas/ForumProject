/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import entity.NewsLetter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mabea
 */
public class NewsLetterDao extends DBConnection{
    public NewsLetter findById(int id){
        NewsLetter c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from news_letters where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new NewsLetter(rs.getInt("id"),rs.getString("mail"),rs.getBoolean("status"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(NewsLetter c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into news_letters(mail,status) values ('"+c.getMail()+"','"+c.getStatus()+"')";
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(NewsLetter c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from news_letters where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(NewsLetter c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update news_letters set mail='"+c.getMail()+"' status="+c.getStatus()+"' where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<NewsLetter> getList(int page,int pageSize){
        List<NewsLetter> list = new ArrayList<>();
        int start = (page-1) * pageSize;
        if(start <0){
            start =0 ;
        }
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from news_letters order by id asc limit "+pageSize+" offset "+start;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new NewsLetter(rs.getInt("id"),rs.getString("mail"),rs.getBoolean("status")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public int count(){
        int count = 0 ;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as count from news_letters";
            
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("count");
                
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
