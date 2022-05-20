
package controller;

import dao.AdminDao;
import entity.Admin;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.List;


@Named(value = "adminBean")
@SessionScoped

public class AdminBean implements Serializable{

   private Admin entity;
    private AdminDao dao;
    private List<Admin> list;
    
    
    public AdminBean() {
    }
    public String getTitle(int id){
        Admin c = this.getDao().findById(id);
        return c.getMail();
    }
    public void clear(){
        entity = new Admin();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new Admin();
    }
    public void delete(Admin c){
        this.getDao().delete(c);
        entity = new Admin();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new Admin();
    }
    public Admin getEntity() {
        if(entity == null) {
            entity = new Admin();
        }
        return entity;
    }

    public void setEntity(Admin entity) {
        this.entity = entity;
    }

    public AdminDao getDao() {
        if(dao == null) {
            dao = new AdminDao();
        }
        return dao;
    }

    public void setDao(AdminDao dao) {
        this.dao = dao;
    }

    public List<Admin> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }
    public Admin findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public boolean validateMail(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        
        String v = (String) value;
        
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Mail alanı boş olamaz"));
        }
        else if(v.length() <5){
            throw new ValidatorException(new FacesMessage("Mail alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }
    
}
