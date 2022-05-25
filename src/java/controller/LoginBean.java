
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
 
   
    
    public void login(){
        
        if(user.getMail().equals("test") && user.getPassword().equals("1234")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("username or password is wrong"));
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
    public LoginBean() {
    }
    
}
