package dao;

import entity.Contact;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CASPER
 */
public class ContactDao extends DBConnection{
    public void create(Contact c){
        try{
            Statement st=this.getConnection().createStatement();
            String query="insert into contacts (user_id,mail,subject,message,status,contact_date) values('"+c.getUser_id()+"','"+c.getMail()+"','"+c.getSubject()+"',"
                    + "'"+c.getMessage()+"','"+c.getStatus()+"','"+c.getContact_date()+"')";
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void update(Contact c){
        try{
            Statement st=this.getConnection().createStatement();
            String query="update contacts set id='"+c.getUser_id()+"','"+c.getMail()+"','"+c.getSubject()+"',"
                    + "'"+c.getMessage()+"','"+c.getStatus()+"','"+c.getContact_date()+"'where id="+c.getId();
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
                list.add(new Contact(rs.getInt("id"),rs.getInt("user_id"),rs.getString("mail")
                        ,rs.getString("subject"),rs.getString("message"),rs.getBoolean("status"),rs.getDate("contact_date")));
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
                c=new Contact(rs.getInt("id"),rs.getInt("user_id"),rs.getString("mail")
                        ,rs.getString("subject"),rs.getString("message"),rs.getBoolean("status"),rs.getDate("contact_date"));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return c;
    }
}
