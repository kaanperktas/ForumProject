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

    private int page=0;
    private int pageSize= 5;
    private int pageCount;
    private Message entity;
    private MessageDao dao;
    private List<Message> list;
    public MessageBean() {
    }
    public void next(){
        if(this.page == this.getPageCount()){
            this.page =1;
        }else{
            this.page++;
        }
        
    }
    public void previous(){System.out.println(page);
        if(this.page == 1){
            this.page =this.getPageCount();
        }else{
            this.page--;
        }
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount= (int)Math.ceil(this.getDao().count()/(double)pageSize); //kaç sayfamız olduğunu bulacak
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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
        this.list = this.getDao().getList(page,pageSize);
        return list;
    }

    public void setList(List<Message> list) {
        this.list = list;
    }
    
    
}