/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.NewsLetterDao;
import entity.NewsLetter;
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
 * @author mabea
 */
@Named(value = "newsLetterBean")
@SessionScoped
public class NewsLetterBean implements Serializable{

    private NewsLetter entity;
    private NewsLetterDao dao;
    private List<NewsLetter> list;
    
    
    public NewsLetterBean() {
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
    public String getTitle(int id){
        NewsLetter c = this.getDao().findById(id);
        return c.getMail();
    }
    public void clear(){
        entity = new NewsLetter();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new NewsLetter();
    }
    public void delete(NewsLetter c){
        this.getDao().delete(c);
        entity = new NewsLetter();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new NewsLetter();
    }
    public NewsLetter getEntity() {
        if(entity == null) {
            entity = new NewsLetter();
        }
        return entity;
    }
    public NewsLetter findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public void setEntity(NewsLetter entity) {
        this.entity = entity;
    }

    public NewsLetterDao getDao() {
        if(dao == null) {
            dao = new NewsLetterDao();
        }
        return dao;
    }

    public void setDao(NewsLetterDao dao) {
        this.dao = dao;
    }

    public List<NewsLetter> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<NewsLetter> list) {
        this.list = list;
    }
}
