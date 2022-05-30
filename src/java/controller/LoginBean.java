
package controller;

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
    private UserBean bean; 

    public UserBean getBean() {
         if(this.bean == null){
            bean = new UserBean();
        }
        return bean;
    }

    public void setBean(UserBean bean) {
        this.bean = bean;
    }
   
     public LoginBean() {
    }
    public String login(){
        
//        if(this.getBean().findByMail(user.getMail()) == null){
//            System.out.println(this.getBean().findByMail(user.getMail()));
//        
//        }
//        
//        else{
//            System.out.println("hataaaaaaaaaaaaaaaaaaa");
//        }
        User u =this.getBean().findByMail(user.getMail());
        if(u != null){
            if(user.getPassword().equals(u.getPassword())){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
            return "/index?faces-redirect=true";
            
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("username or password is wrong"));
                return "/session/login?faces-redirect=true";
            }
        }
        else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("kullanıcı bulunamadı"));
             return "/session/login?faces-redirect=true";
        }
        
        
    }
    
    public User getUser() {
        if(this.user == null){
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   
    
}
