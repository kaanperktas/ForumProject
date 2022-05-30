/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import dao.GroupDao;
import entity.SystemGroup;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;


@Named
@SessionScoped
public class GroupBean implements Serializable{
    private SystemGroup entity;
    private GroupDao dao;
    private List<SystemGroup> list;
 
    public SystemGroup getEntity() {
        if (this.entity==null) {
            this.entity=new SystemGroup();
        }
        return entity;
    }

    public void clearForm(){
        this.entity=new SystemGroup();
    }
    public void create(){
        this.getDao().create(entity);
        this.entity=new SystemGroup();
    }
    public void update(){
        this.getDao().update(entity);
        this.entity=new SystemGroup();
    }
    public void delete(){
        this.getDao().delete(entity);
        this.entity=new SystemGroup();
    }
    public void setEntity(SystemGroup entity) {
        this.entity = entity;
    }

    public GroupDao getDao() {
        if (this.dao==null) {
            this.dao=new GroupDao();
        }
        return dao;
    }

    public void setDao(GroupDao dao) {
        this.dao = dao;
    }

    public List<SystemGroup> getList() {
        this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<SystemGroup> list) {
        this.list = list;
    }
    
}