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
