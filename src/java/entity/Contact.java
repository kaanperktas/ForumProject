/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author CASPER
 */
public class Contact {
    private int id;
    private int user_id;
    private String mail;
    private String subject;
    private String message;
    private Boolean status;
    private Date contact_date;

    public Contact() {
        
    }   
    public Contact(int id, int user_id, String mail, String subject, String message, Boolean status, Date contact_date) {
        this.id = id;
        this.user_id = user_id;
        this.mail = mail;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.contact_date = contact_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public Date getContact_date() {
        return contact_date;
    }

    public void setContact_date(Date contact_date) {
        this.contact_date = contact_date;
    }
    
}
