/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author mabea
 */
public class Notification {
    private int id;
    private String type;
    private String detail;
    private Timestamp notification_date;
    private Boolean status;

    public int getId() {
        return id;
    }

    public Notification() {
    }

    public Timestamp getNotification_date() {
        return notification_date;
    }

    public void setNotification_date(Timestamp notification_date) {
        this.notification_date = notification_date;
    }

    public Notification(int id, String type, String detail, Timestamp notification_date, Boolean status) {
        this.id = id;
        this.type = type;
        this.detail = detail;
        this.notification_date = notification_date;
        this.status = status;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

  
}
