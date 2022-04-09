/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Notification;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mabea
 */
public class NotificationDao extends DBConnection{
    public Notification findById(int id){
        Notification c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from notification where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new Notification(rs.getInt("id"),rs.getString("type"),rs.getString("detail"),rs.getDate("notification_date")
                        ,rs.getBoolean("status")
                );
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(Notification c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into notification(type,detail,notification_date,sttaus) values "
                    + "('"+c.getType()+"','"+c.getDetail()+"','"+c.getNotification_date()+"','"+c.getStatus()+"')";
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Notification c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from notification where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Notification c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update notification set type='"+c.getType()+"' where id="+c.getId()+"' where detail="+c.getDetail()
                    +"' where notification_date="+c.getNotification_date()
                    +"' where status="+c.getStatus();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Notification> getList(){
        List<Notification> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from notification";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Notification(rs.getInt("id"),rs.getString("type"),rs.getString("detail"),rs.getDate("notification_date")
                        ,rs.getBoolean("status")
                ));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
