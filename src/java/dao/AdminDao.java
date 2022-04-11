
package dao;
import entity.Admin;
import entity.User;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends DBConnection {
    
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
    
      public   Admin findById(int id){
        Admin c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from admins where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new Admin(rs.getInt("id"), rs.getString("mail"),rs.getString("password"),this.userDao.findById(rs.getInt("user_id")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(Admin c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into admins(mail,user_id,password) values "
                    + "('"+c.getMail()+"','"+c.getUser().getId()+"','"+c.getPassword()+"')";
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Admin c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from admins where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Admin c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update admins set mail='"+c.getMail()+"', user_id='"+c.getUser().getId()+"', password='"+c.getPassword()+"' where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Admin> getList(){
        List<Admin> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from admins";
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                User u = this.getUserDao().findById(rs.getInt("user_id"));
                list.add(new Admin(rs.getInt("id"), rs.getString("mail"),rs.getString("password"),u));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
