package controller;

import dao.UserDao;
import entity.User;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

@Named(value = "lc")
@SessionScoped
public class LoginBean implements Serializable {

    private User user;
    private UserDao dao;

    public UserDao getDao() {
        if(this.dao == null){
            this.dao = new UserDao();
        }
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    

    public LoginBean() {
    }

    public String login() {
        User u = this.getDao().findByMail(user.getMail());
        if (u != null) {
            if (user.getPassword().equals(u.getPassword())) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u);
                return "/index?faces-redirect=true";

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("username or password is wrong"));
                return "/session/login?faces-redirect=true";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("kullanıcı bulunamadı"));
            return "/session/login?faces-redirect=true";
        }

    }

    public User getUser() {
        if (this.user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
