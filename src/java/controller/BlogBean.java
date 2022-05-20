/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.BlogDao;
import entity.Blog;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gökhan
 */
@Named(value = "blogBean")
@SessionScoped

public class BlogBean implements Serializable {


   private Blog entity;
    private BlogDao dao;
    private List<Blog> list;
    
    
    public BlogBean() {
    }
    public String getTitle(int id){
        Blog c = this.getDao().findById(id);
        return c.getTitle();
    }
    public void clear(){
        entity = new Blog();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new Blog();
    }
    public void delete(Blog c){
        this.getDao().delete(c);
        entity = new Blog();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new Blog();
    }
    public Blog getEntity() {
        if(entity == null) {
            entity = new Blog();
        }
        return entity;
    }

    public void setEntity(Blog entity) {
        this.entity = entity;
    }

    public BlogDao getDao() {
        if(dao == null) {
            dao = new BlogDao();
        }
        return dao;
    }

    public void setDao(BlogDao dao) {
        this.dao = dao;
    }

    public List<Blog> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Blog> list) {
        this.list = list;
    }
    public Blog findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public boolean validateTitle(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        
        String v = (String) value;
        
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Title alanı boş olamaz"));
        }
        else if(v.length() <5){
            throw new ValidatorException(new FacesMessage("Title alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }
    
}
