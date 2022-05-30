/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import entity.Privileges;
import entity.SystemGroup;
import java.util.ArrayList;
import java.util.List;
import dao.DBConnection;

/**
 *
 * @author CASPER
 */
public class PrivilegeDao extends DBConnection{

    private GroupDao gdao;
    public PrivilegeDao() {
    }
    public Privileges getGroupPrivileges(SystemGroup sg, String module) {
        Privileges priv=null;
        try {
            Statement st =this.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from privileges where sgroup="+sg.getId()+"and mname='"+module+"'");
            rs.next();  
            SystemGroup g=this.getGdao().getById(rs.getLong("sgroup"));
            priv=new Privileges(rs.getLong("id"),g,rs.getString("mname"),rs.getBoolean("icreate"),rs.getBoolean("iread"),rs.getBoolean("iupdate"),rs.getBoolean("idelete"),rs.getBoolean("ilist"),rs.getBoolean("irshow"));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return priv;
    }
    public List<Privileges> readList(){
        List<Privileges> list=new ArrayList<>();
        try {
            Statement st =this.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from privileges");
            while (rs.next()) {     
                SystemGroup g=this.getGdao().getById(rs.getLong("sgroup"));
                list.add(new Privileges(rs.getLong("id"),g,rs.getString("mname"),rs.getBoolean("icreate"),rs.getBoolean("iread"),rs.getBoolean("iupdate"),rs.getBoolean("idelete"),rs.getBoolean("ilist"),rs.getBoolean("irshow")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void create(Privileges c){
        try {
            Statement st =this.getConnection().createStatement();
            st.executeUpdate("insert into privileges(sgroup,mname,icreate,iread,iupdate,idelete,ilist,irshow) values('"+c.getSgroup().getId()+"','"+c.getName()+"','"+c.isIcreate()+"','"+c.isIread()+"','"+c.isIupdate()+"','"+c.isIdelete()+"','"+c.isIlist()+"','"+c.isIrshow()+"')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Privileges c){
        try {
            Statement st =this.getConnection().createStatement();
            st.executeUpdate("update privileges set mname='"+c.getName()+"' where id="+c.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Privileges c){
        try {
            Statement st =this.getConnection().createStatement();
            st.executeUpdate("delete from privileges where id="+c.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public GroupDao getGdao() {
        if (this.gdao == null) {
            this.gdao = new GroupDao();
        }
        return gdao;
    }
    
    public void setGdao(GroupDao gdao) {
        this.gdao = gdao;
    }

    
}
