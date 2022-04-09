
package dao;
import entity.User;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DBConnection {
    User findById(int id){
        User c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from user where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new User(rs.getInt("id"), rs.getString("mail"),rs.getString("password"),rs.getString("firsName"),rs.getString("lastName"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(User c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into user(mail,password,firstName,lastName) values ('"+c.getMail()+"','"+c.getPassword()+"','"+c.getFirstName()+"''"+c.getLastName()+"')";
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(User c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from user where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(User c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update user set mail='"+c.getMail()+"' where password="+c.getPassword()+"' where firstName="+c.getFirstName()+"' where lastName="+c.getLastName()+"' where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<User> getList(){
        List<User> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from user";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new User(rs.getInt("id"), rs.getNString("mail"),rs.getString("password"),rs.getString("firstName"),rs.getString("lastName")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}
