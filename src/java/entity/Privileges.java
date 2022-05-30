/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author CASPER
 */
public class Privileges implements Serializable{
    private int id;
    private SystemGroup sgroup;
    private String name;
    private boolean icreate;
    private boolean iread;
    private boolean iupdate;
    private boolean idelete;
    private boolean ilist;
    private boolean irshow;

    public Privileges() {
    }


    public Privileges(int id,SystemGroup sgroup, String name, boolean icreate, boolean iread, boolean iupdate, boolean idelete, boolean ilist, boolean irshow) {
        this.id = id;
        this.sgroup=sgroup;
        this.name = name;
        this.icreate = icreate;
        this.iread = iread;
        this.iupdate = iupdate;
        this.idelete = idelete;
        this.ilist = ilist;
        this.irshow = irshow;
    }

    public SystemGroup getSgroup() {
        return sgroup;
    }

    public void setSgroup(SystemGroup sgroup) {
        this.sgroup = sgroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIcreate() {
        return icreate;
    }

    public void setIcreate(boolean icreate) {
        this.icreate = icreate;
    }

    public boolean isIread() {
        return iread;
    }

    public void setIread(boolean iread) {
        this.iread = iread;
    }

    public boolean isIupdate() {
        return iupdate;
    }

    public void setIupdate(boolean iupdate) {
        this.iupdate = iupdate;
    }

    public boolean isIdelete() {
        return idelete;
    }

    public void setIdelete(boolean idelete) {
        this.idelete = idelete;
    }

    public boolean isIlist() {
        return ilist;
    }

    public void setIlist(boolean ilist) {
        this.ilist = ilist;
    }

    public boolean isIrshow() {
        return irshow;
    }

    public void setIrshow(boolean irshow) {
        this.irshow = irshow;
    }

    @Override
    public String toString() {
        return "Privileges{" + "id=" + id + ", sgroup=" + sgroup + ", name=" + name + ", icreate=" + icreate + ", iread=" + iread + ", iupdate=" + iupdate + ", idelete=" + idelete + ", ilist=" + ilist + ", irshow=" + irshow + '}';
    }
    
    
}
