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
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gökhan
 */
@Named(value = "commentLayer")
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
}
