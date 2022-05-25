/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.Blog;
import entity.Category;
import entity.Writer;
import java.sql.Timestamp;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gökhan
 */
public class BlogDao extends DBConnection{
    CategoryDao categoryDao;
    WriterDao writerDao;
    public Blog findById(int id){
        Blog c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from blogs where id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Category k=this.getCategoryDao().findById(rs.getInt("category_id"));
                Writer w=this.getWriterDao().findById(rs.getInt("writer_id"));
                c = new Blog(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getString("image"),
                        rs.getTimestamp("create_date"),k,rs.getBoolean("status"),w);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
        
    public void create(Blog c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into blogs(title,content,image,create_date,category_id,status,writer_id) values "
                    + "('"+c.getTitle()+"','"+c.getContent()+"','"+c.getImage()+"','"+new Timestamp(System.currentTimeMillis())+"','"+c.getCategory().getId()+"','"+c.getStatus()+"'"
                    + ",'"+c.getWriter().getId()+"')";
            st.executeUpdate(query);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Blog c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from blogs where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(Blog c){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update blogs set title='"+c.getTitle()+"', content='"+c.getContent()
                    +"', image='"+c.getImage()
                    +"', create_date='"+c.getCreate_date()
                    +"', category_id="+c.getCategory().getId()
                    +", status='"+c.getStatus()
                    +"', writer_id="+c.getWriter().getId()
                    +" where id="+c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Blog> getList(int page,int pageSize){
        List<Blog> list = new ArrayList<>();
        int start = (page-1) * pageSize;
        if(start <0){
            start =0 ;
        }
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from blogs order by id asc limit "+pageSize+" offset "+start;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Category c=this.getCategoryDao().findById(rs.getInt("category_id"));
                Writer w=this.getWriterDao().findById(rs.getInt("writer_id"));
                list.add(new Blog(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getString("image"),
                        rs.getTimestamp("create_date"),c,rs.getBoolean("status") ,w));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public CategoryDao getCategoryDao() {
        if(categoryDao==null){
            this.categoryDao=new CategoryDao();
        }
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public WriterDao getWriterDao() {
        if(writerDao==null){
            this.writerDao=new WriterDao();
        }
        return writerDao;
    }

    public void setWriterDao(WriterDao writerDao) {
        this.writerDao = writerDao;
    }
    
    public int count(){
        int count = 0 ;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as count from blogs";
            
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("count");
                
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    
}