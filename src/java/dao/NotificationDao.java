/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Notification;
import java.sql.Timestamp;
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
            String query = "select * from notifications where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new Notification(rs.getInt("id"),rs.getString("type"),rs.getString("detail"),rs.getTimestamp("notifications_date")
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
            
            String query = "insert into notifications(id,type,detail,notifications_date,status) values "
                    + "('"+c.getId()+"','"+c.getType()+"','"+c.getDetail()+"','"+new Timestamp(System.currentTimeMillis())+"','"+c.getStatus()+"')";
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Notification c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from notifications where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Notification c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update notifications set type='"+c.getType()+"',detail='"+c.getDetail()
                    +"',notifications_date='"+c.getNotification_date()
                    +"',status='"+c.getStatus()+ "' where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Notification> getList(){
        List<Notification> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from notifications";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Notification(rs.getInt("id"),rs.getString("type"),rs.getString("detail"),rs.getTimestamp("notifications_date")
                        ,rs.getBoolean("status")
                ));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
