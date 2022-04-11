package dao;

import entity.Contact;
import entity.User;
import java.sql.Timestamp;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CASPER
 */
public class ContactDao extends DBConnection{
    
    private UserDao userDao;

    public UserDao getUserDao() {
        if(this.userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    
    public void create(Contact c){
        try{
            Statement st=this.getConnection().createStatement();
            String query="insert into contacts (user_id,mail,subject,message,status,contacts_date) "
                    + "values('"+c.getUser().getId()+"','"+c.getMail()+"','"+c.getSubject()+"',"
                    + "'"+c.getMessage()+"','"+c.getStatus()+"','"+new Timestamp(System.currentTimeMillis())+"')";
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void update(Contact c){
        try{
            Statement st=this.getConnection().createStatement();
            String query="update contacts set user_id="+c.getUser().getId()+" ,mail='"+c.getMail()+"',subject='"+c.getSubject()+"',"
                    + "message='"+c.getMessage()+"',status='"+c.getStatus()+"',contacts_date='"+c.getContact_date()+"'where id="+c.getId();
            
            
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void delete(Contact c){
        try{
            Statement st=this.getConnection().createStatement();
            String query="delete from contacts where id="+c.getId();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<Contact> getList(){
        List<Contact> list=new ArrayList<>();
        try{
            Statement st=this.getConnection().createStatement();
            String query="select * from contacts";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                User u = this.getUserDao().findById(rs.getInt("user_id"));
                list.add(new Contact(rs.getInt("id"),u,rs.getString("mail")
                        ,rs.getString("subject"),rs.getString("message"),rs.getBoolean("status"),rs.getTimestamp("contacts_date")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    public Contact findById(int id){
        Contact c=null;
        try{
            Statement st=this.getConnection().createStatement();
            String query="select * from contacts where id="+id;
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                User u = this.getUserDao().findById(rs.getInt("user_id"));
                c=new Contact(rs.getInt("id"),u,rs.getString("mail")
                        ,rs.getString("subject"),rs.getString("message"),rs.getBoolean("status"),rs.getTimestamp("contacts_date"));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return c;
    }
}
