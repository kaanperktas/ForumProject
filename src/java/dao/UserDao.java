package dao;

import entity.SystemGroup;
import entity.User;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DBConnection {

    GroupDao gdao;

    public UserDao() {
    }

    public GroupDao getGdao() {
        if(gdao==null){
            this.gdao=new GroupDao();
        }
        return gdao;
    }

    public void setGdao(GroupDao gdao) {
        this.gdao = gdao;
    }

//     
    public User findById(int id) {
        User c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from users where id=" + id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SystemGroup g = this.getGdao().getById(rs.getInt("ugroup"));
                c = new User(rs.getInt("id"), rs.getString("mail"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"), g);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public User findByMail(String mail) {
        User c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from users where mail='"+mail+"'";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SystemGroup g = this.getGdao().getById(rs.getInt("ugroup"));
                c = new User(rs.getInt("id"), rs.getString("mail"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"), g);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public void create(User c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into users(mail,password,first_name,last_name,ugroup) values"
                    + " ('" + c.getMail() + "','" + c.getPassword() + "','" + c.getFirstName() + "','" + c.getLastName() + "','" + c.getGroup().getId() + "')";

            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(User c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from users where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(User c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update users set mail='" + c.getMail() + "', password='" + c.getPassword() + "', first_name='" + c.getFirstName() + "', last_name='" + c.getLastName() + "', ugroup='" + c.getGroup().getId() + "' where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getList(int page, int pageSize) {
        List<User> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from users order by id asc limit " + pageSize + " offset " + start;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SystemGroup g = this.getGdao().getById(rs.getInt("ugroup"));
                list.add(new User(rs.getInt("id"), rs.getString("mail"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"), g));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as count from users";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
