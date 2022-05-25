
package controller;

import dao.UserDao;
import entity.User;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import utils.Utils;

@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {


   private User entity;
    private UserDao dao;
    private List<User> list;
    private Part file1;
	private String message;

    

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

  

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String uploadFile() throws IOException {
		boolean file1Success = false;

		if (file1 != null && file1.getSize() > 0) {
			String fileName = Utils.getFileNameFromPart(file1);

			
			File savedFile = new File("/internet", fileName);

			

			try (InputStream input = file1.getInputStream()) {
				Files.copy(input, savedFile.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}

			file1Success = true;
		}


		if (file1Success) {
			
			setMessage("Dosya başarıyla yüklendi");
		} else {
			
			setMessage("Dosya yüklenemedi. Lütfen başka bir dosya seçiniz!!");
		}

		
		return null;
	}
    
    public UserBean() {
    }
    public String getTitle(int id){
        User c = this.getDao().findById(id);
        return c.getMail();
    }
    public void clear(){
        entity = new User();
    }
    public void create(){
        this.getDao().create(entity);
        entity = new User();
    }
    public void delete(User c){
        this.getDao().delete(c);
        entity = new User();
    }
    public void update(){
        this.getDao().update(entity);
        entity = new User();
    }
    public User getEntity() {
        if(entity == null) {
            entity = new User();
        }
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

    public UserDao getDao() {
        if(dao == null) {
            dao = new UserDao();
        }
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public List<User> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
    public User findById(){
        return this.getDao().findById(entity.getId());
       
    }
    public User findByMail(String mail){
        return this.getDao().findByMail(mail);
    }
    public User findByPassword(String password){
        return this.getDao().findByPassword(password);
    }
    public boolean validatePassword(FacesContext context,UIComponent cmp,Object value)throws ValidatorException{
        
        String v = (String) value;
        
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Password alanı boş olamaz"));
        }
        else if(v.length() <5){
            throw new ValidatorException(new FacesMessage("Password alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }
}
