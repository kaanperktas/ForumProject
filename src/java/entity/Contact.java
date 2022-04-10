/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author CASPER
 */
public class Contact {
    private int id;
    private User user;
    private String mail;
    private String subject;
    private String message;
    private Boolean status;
    private Timestamp contact_date;

    public Contact() {
        
    }   

    public Contact(int id, User user, String mail, String subject, String message, Boolean status, Timestamp contact_date) {
        this.id = id;
        this.user = user;
        this.mail = mail;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.contact_date = contact_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getContact_date() {
        return contact_date;
    }

    public void setContact_date(Timestamp contact_date) {
        this.contact_date = contact_date;
    }
    
  
}
