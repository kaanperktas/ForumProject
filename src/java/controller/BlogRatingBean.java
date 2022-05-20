/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.Blog_RatingDao;
import entity.Blog_Rating;
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
@Named(value = "blogRatingBean")
@SessionScoped

public class BlogRatingBean implements Serializable{

     private Blog_Rating entity;
    private Blog_RatingDao dao;
    private List<Blog_Rating> list;
    
    
    public BlogRatingBean() {
    }
    
    public void clear(){
        entity = new Blog_Rating();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new Blog_Rating();
    }
    public void delete(Blog_Rating c){
        this.getDao().delete(c);
        entity = new Blog_Rating();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new Blog_Rating();
    }
    public Blog_Rating getEntity() {
        if(entity == null) {
            entity = new Blog_Rating();
        }
        return entity;
    }

    public void setEntity(Blog_Rating entity) {
        this.entity = entity;
    }

    public Blog_RatingDao getDao() {
        if(dao == null) {
            dao = new Blog_RatingDao();
        }
        return dao;
    }

    public void setDao(Blog_RatingDao dao) {
        this.dao = dao;
    }

    public List<Blog_Rating> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Blog_Rating> list) {
        this.list = list;
    }
    public Blog_Rating findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public boolean validateTotalScore(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        
        int v = (int) value;
        
        if(v < 10){
            throw new ValidatorException(new FacesMessage("Total Score alanı 10'dan küçük olamaz"));
        }
        
        return true;
    }
    
    
}
