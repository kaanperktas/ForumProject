/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CommentDao;
import entity.Comment;
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
@Named(value = "commentBean")
@SessionScoped

public class CommentBean implements Serializable {
     private Comment entity;
    private CommentDao dao;
    private List<Comment> list;
    
    
    public CommentBean() {
    }
    
    public void clear(){
        entity = new Comment();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new Comment();
    }
    public void delete(Comment c){
        this.getDao().delete(c);
        entity = new Comment();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new Comment();
    }
    public Comment getEntity() {
        if(entity == null) {
            entity = new Comment();
        }
        return entity;
    }

    public void setEntity(Comment entity) {
        this.entity = entity;
    }

    public CommentDao getDao() {
        if(dao == null) {
            dao = new CommentDao();
        }
        return dao;
    }

    public void setDao(CommentDao dao) {
        this.dao = dao;
    }

    public List<Comment> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }
    public Comment findById(){
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
