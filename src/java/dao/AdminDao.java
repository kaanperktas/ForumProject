
package dao;
import entity.Admin;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends DBConnection {
      public   Admin findById(int id){
        Admin c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from admin where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new Admin(rs.getInt("id"), rs.getNString("mail"),rs.getString("password"),rs.getInt("user_id"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(Admin c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into admin(mail,password,user_id) values ('"+c.getMail()+"','"+c.getPassword()+"','"+c.getUser_id()+"')";
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Admin c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from admin where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Admin c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update admin set mail='"+c.getMail()+"' where password="+c.getPassword()+"' where id="+c.getId()+"' where user_id="+c.getUser_id();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Admin> getList(){
        List<Admin> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from admin";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Admin(rs.getInt("id"), rs.getNString("mail"),rs.getString("password"),rs.getInt("user_id")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
