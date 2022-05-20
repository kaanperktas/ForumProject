package controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
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
    public boolean validate(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        String v=(String) value; 
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Gönderici Adı Alanı Boş Olamaz!"));
        }
        return true;
    }
    public String getDetails(int id){
        Message m=this.getDao().findById(id);
        return m.getDetails();
    }
    public Message findById(){
        return this.getDao().findById(entity.getId());
    }

    public Message getEntity() {
        if(this.entity == null){
            entity = new Message();
        }
        return entity;
    }

    public void setEntity(Message entity) {
        this.entity = entity;
    }

    public MessageDao getDao() {
        if(this.dao == null){
            dao = new MessageDao();
        }
        return dao;
    }

    public void setDao(MessageDao dao) {
        this.dao = dao;
    }

    public List<Message> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Message> list) {
        this.list = list;
    }
    
    
}