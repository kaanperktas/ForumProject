/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Writer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mabea
 */
public class WriterDao extends DBConnection{
    public Writer findById(int id){
        Writer c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from writers where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new Writer(rs.getInt("id"),rs.getString("name"),rs.getString("about"),rs.getString("mail")
                ,rs.getString("image")
                ,rs.getString("password")
                ,rs.getBoolean("status"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(Writer c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into writers(id,name,about,mail,image,password,status) values('"+c.getId()+"',+'"+c.getName()+"','"+c.getAbout()+"',"
                 +    "'"+c.getMail()+"','"+c.getImage()+"','"+c.getPassword()+"'"
                  +   ",'"+c.getStatus()+"')";
        
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Writer c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from writer where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Writer c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update writer name='"+c.getName()+"' where about="+c.getAbout()
                    +"' where id="+c.getId()
                    +"' where mail="+c.getMail()
                    +"' where image="+c.getImage()
                    +"' where password="+c.getPassword()
                    +"' where status="+c.getStatus()
                    ;
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Writer> getList(){
        List<Writer> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from writers";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Writer(rs.getInt("id"),rs.getString("name"),rs.getString("about"),rs.getString("mail")
                ,rs.getString("image")
                ,rs.getString("password")
                ,rs.getBoolean("status")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
