/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;


import dao.NotificationDao;
import entity.Notification;
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
/**
 *
 * @author mabea
 */
@Named(value = "notificationBean")
@SessionScoped
public class NotificationBean implements Serializable{

    private Notification entity;
    private NotificationDao dao;
    private List<Notification> list;
    
    
    public NotificationBean() {
    }
    public boolean validateType(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        
        String v = (String) value;
        
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Tür alanı boş olamaz"));
        }
        else if(v.length() <5){
            throw new ValidatorException(new FacesMessage("Tür alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }
    public boolean validateDetail(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        
        String v = (String) value;
        
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Detay alanı boş olamaz"));
        }
        else if(v.length() <5){
            throw new ValidatorException(new FacesMessage("Detay alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }
    public String getTitle(int id){
        Notification c = this.getDao().findById(id);
        return c.getDetail();
    }
    public void clear(){
        entity = new Notification();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new Notification();
    }
    public void delete(Notification c){
        this.getDao().delete(c);
        entity = new Notification();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new Notification();
    }
    public Notification getEntity() {
        if(entity == null) {
            entity = new Notification();
        }
        return entity;
    }

    public void setEntity(Notification entity) {
        this.entity = entity;
    }

    public NotificationDao getDao() {
        if(dao == null) {
            dao = new NotificationDao();
        }
        return dao;
    }
    public Notification findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public void setDao(NotificationDao dao) {
        this.dao = dao;
    }

    public List<Notification> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Notification> list) {
        this.list = list;
    }

}
