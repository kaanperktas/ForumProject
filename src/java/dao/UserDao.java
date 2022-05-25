
package dao;
import entity.User;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DBConnection {

    public UserDao() {
    }
    
    
    public User findById(int id){
        User c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from users where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new User(rs.getInt("id"), rs.getString("mail"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
       public User findByMail(String mail){
        User c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from users where mail='"+mail+"'";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new User(rs.getInt("id"), rs.getString("mail"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    } 
       public User findByPassword(String password){
        User c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from users where passsword="+password;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new User(rs.getInt("id"), rs.getString("mail"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    } 
    public void create(User c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into users(mail,password,first_name,last_name) values"
                    + " ('"+c.getMail()+"','"+c.getPassword()+"','"+c.getFirstName()+"','"+c.getLastName()+"')";
     
            
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(User c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from users where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(User c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update users set mail='"+c.getMail()+"', password='"+c.getPassword()+"', first_name='"+c.getFirstName()+"', last_name='"+c.getLastName()+"' where id="+c.getId();


                       st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<User> getList(){
        List<User> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from users";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new User(rs.getInt("id"), rs.getString("mail"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}
