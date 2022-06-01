/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Document;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mabea
 */
public class DocumentDao extends DBConnection{
    public Document findById(int id){
        Document c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from documents where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new Document(rs.getInt("id"), rs.getString("file_path"),rs.getString("file_name"),rs.getString("file_type"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(Document c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into documents(file_path,file_name,file_type) values ('"+c.getFilePath()+"','"+c.getFileName()+"','"+c.getFileType()+"')";
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Document c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from documents where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Document c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update documents set file_path='"+c.getFilePath()+"' , file_name='"+c.getFileName()+"' , file_type='"+c.getFileType()+"' where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Document> getList(){
        List<Document> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from documents";
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Document(rs.getInt("id"), rs.getString("file_path"),rs.getString("file_name"),rs.getString("file_type")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
