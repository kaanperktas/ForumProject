
package controller;

import dao.UserDao;
import entity.User;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "userBean")
@Dependent
public class UserBean {

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
    
}
