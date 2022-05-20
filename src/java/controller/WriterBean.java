/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.WriterDao;
import entity.Writer;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author mabea
 */
@Named(value = "writerBean")
@SessionScoped
public class WriterBean implements Serializable{

    private Writer entity;
    private WriterDao dao;
    private List<Writer> list;
    
    
    public WriterBean() {
    }
    public String getTitle(int id){
        Writer c = this.getDao().findById(id);
        return c.getName();
    }
    public void clear(){
        entity = new Writer();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new Writer();
    }
    public void delete(Writer c){
        this.getDao().delete(c);
        entity = new Writer();
    }
     public Writer findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public void update(){
        this.getDao().update(entity);
        entity = new Writer();
    }
    public Writer getEntity() {
        if(entity == null) {
            entity = new Writer();
        }
        return entity;
    }

    public void setEntity(Writer entity) {
        this.entity = entity;
    }

    public WriterDao getDao() {
        if(dao == null) {
            dao = new WriterDao();
        }
        return dao;
    }

    public void setDao(WriterDao dao) {
        this.dao = dao;
    }

    public List<Writer> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Writer> list) {
        this.list = list;
    }

    
}
