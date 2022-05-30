/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import dao.PrivilegeDao;
import entity.Privileges;
import entity.SystemGroup;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;


@Named(value="privilegesBean")
@SessionScoped
public class PrivilegesBean implements Serializable{
    private Privileges entity;
    private PrivilegeDao dao;
    private List<Privileges> list;

    public Privileges getEntity() {
        if (this.entity==null) {
            this.entity=new Privileges();
        }
        return entity;
    }

    public Privileges getPrivileges(SystemGroup sg,String module){
        return this.getDao().getGroupPrivileges(sg,module);
    }
    public void clearForm(){
        this.entity=new Privileges();
    }
    public void create(){
        this.getDao().create(entity);
        this.entity=new Privileges();
    }
    public void update(){
        this.getDao().update(entity);
        this.entity=new Privileges();
    }
    public void delete(){
        this.getDao().delete(entity);
        this.entity=new Privileges();
    }
    public void setEntity(Privileges entity) {
        this.entity = entity;
    }

    public PrivilegeDao getDao() {
        if (this.dao==null) {
            this.dao=new PrivilegeDao();
        }
        return dao;
    }

    public void setDao(PrivilegeDao dao) {
        this.dao = dao;
    }

    public List<Privileges> getList() {
        this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<Privileges> list) {
        this.list = list;
    }
    
}