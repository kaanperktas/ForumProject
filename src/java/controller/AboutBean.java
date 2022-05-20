
package controller;

import dao.AboutDao;
import entity.About;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.List;


@Named(value = "aboutBean")
@SessionScoped
public class AboutBean implements Serializable {

private About entity;
    private AboutDao dao;
    private List<About> list;
    
    
    public AboutBean() {
    }
    public String getTitle(int id){
        About c = this.getDao().findById(id);
        return c.getImage();
    }
    public void clear(){
        entity = new About();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new About();
    }
    public void delete(About c){
        this.getDao().delete(c);
        entity = new About();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new About();
    }
    public About getEntity() {
        if(entity == null) {
            entity = new About();
        }
        return entity;
    }

    public void setEntity(About entity) {
        this.entity = entity;
    }

    public AboutDao getDao() {
        if(dao == null) {
            dao = new AboutDao();
        }
        return dao;
    }

    public void setDao(AboutDao dao) {
        this.dao = dao;
    }

    public List<About> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<About> list) {
        this.list = list;
    }
    public About findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public boolean validateDetail(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        
        String v = (String) value;
        
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Detail alanı boş olamaz"));
        }
        else if(v.length() <5){
            throw new ValidatorException(new FacesMessage("Detail alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }
}
