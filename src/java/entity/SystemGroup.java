/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author CASPER
 */
public class SystemGroup implements Serializable{
    private int id;
    private String gname;

    public SystemGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SystemGroup(int id, String gname) {
        this.id = id;
        this.gname = gname;
    }

    

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemGroup other = (SystemGroup) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "SystemGroup{" + "id=" + id + ", gname=" + gname + '}';
    }
    
}
