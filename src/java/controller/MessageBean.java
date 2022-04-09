package controller;

import dao.MessageDao;
import entity.Message;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named(value="messageBean")
@SessionScoped
public class MessageBean implements Serializable{

    private Message entity;
    private MessageDao dao;
    private List<Message> list;
    public MessageBean() {
    }
    public void create(){
        this.getDao().create(entity);
        entity=new Message();
    }
    public void update(){
        this.getDao().update(entity);
        entity=new Message();
    }
    public void delete(Message c){
        this.getDao().delete(c);
        entity=new Message();
    }
    public void clear(){
        entity=new Message();
    }
    public String getDetails(int id){
        Message m=this.getDao().findById(id);
        return m.getDetails();
    }

    public Message getEntity() {
        return entity;
    }

    public void setEntity(Message entity) {
        this.entity = entity;
    }

    public MessageDao getDao() {
        return dao;
    }

    public void setDao(MessageDao dao) {
        this.dao = dao;
    }

    public List<Message> getList() {
        return list;
    }

    public void setList(List<Message> list) {
        this.list = list;
    }
    
    
}

