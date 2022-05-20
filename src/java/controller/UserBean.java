
package controller;

import dao.UserDao;
import entity.User;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.List;

@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {


   private User entity;
    private UserDao dao;
    private List<User> list;
    
    
    public UserBean() {
    }
    public String getTitle(int id){
        User c = this.getDao().findById(id);
        return c.getMail();
    }
    public void clear(){
        entity = new User();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new User();
    }
    public void delete(User c){
        this.getDao().delete(c);
        entity = new User();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new User();
    }
    public User getEntity() {
        if(entity == null) {
            entity = new User();
        }
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

    public UserDao getDao() {
        if(dao == null) {
            dao = new UserDao();
        }
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public List<User> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
    public User findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public boolean validatePassword(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        
        String v = (String) value;
        
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Password alanı boş olamaz"));
        }
        else if(v.length() <5){
            throw new ValidatorException(new FacesMessage("Password alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }
}
