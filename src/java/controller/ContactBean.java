/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ContactDao;
import entity.Contact;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named(value="contactBean")
@SessionScoped
public class ContactBean implements Serializable{

    private Contact entity;
    private ContactDao dao;
    private List<Contact> list;
    public ContactBean() {
    }
    public void create(){
        this.getDao().create(entity);
        entity=new Contact();
    }
    public void update(){
        this.getDao().update(entity);
        entity=new Contact();
    }
    public void delete(Contact c){
        this.getDao().delete(c);
        entity=new Contact();
    }
    public void clear(){
        entity=new Contact();
    }
    public String getMessage(int id){
        Contact c=this.getDao().findById(id);
        return c.getMessage();
    }

    public Contact getEntity() {
        return entity;
    }

    public void setEntity(Contact entity) {
        this.entity = entity;
    }

    public ContactDao getDao() {
        return dao;
    }

    public void setDao(ContactDao dao) {
        this.dao = dao;
    }

    public List<Contact> getList() {
        return list;
    }

    public void setList(List<Contact> list) {
        this.list = list;
    }
    
    
}
