
package entity;

import java.util.List;


public class Admin {
    private int id;
    private String mail;
    private String password;
    private User user;

    
    public Admin() {
    }

    public Admin(int id, String mail, String password, User user) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
