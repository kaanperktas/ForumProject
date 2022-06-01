package controller;

import dao.DocumentDao;
import dao.UserDao;
import entity.Document;
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
import java.nio.file.StandardCopyOption;
import java.util.List;
import utils.Utils;

@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private int page = 0;
    private int pageSize = 5;
    private int pageCount;
    private User entity;
    private UserDao dao;
    private List<User> list;
    private Part file1;
    private String message;
    private Document document;
    private DocumentDao documentDao;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        System.out.println(page);
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }
    public DocumentDao getDocumentDao() {
        if(this.documentDao == null){
            this.documentDao = new DocumentDao();
        }
        return documentDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }
    
    
    public Document getDocument() {
        if(this.document == null){
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize); //kaç sayfamız olduğunu bulacak
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

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
                Files.copy(input, savedFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
                document = this.getDocument();
                document.setFilePath(savedFile.getParent());
                document.setFileName(savedFile.getName());
                document.setFileType(file1.getContentType());
                
                this.getDocumentDao().create(document);
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

    public String getTitle(int id) {
        User c = this.getDao().findById(id);
        return c.getMail();
    }

    public void clear() {
        entity = new User();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new User();
    }

    public void delete(User c) {
        this.getDao().delete(c);
        entity = new User();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new User();
    }

    public User getEntity() {
        if (entity == null) {
            entity = new User();
        }
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

    public UserDao getDao() {
        if (dao == null) {
            dao = new UserDao();
        }
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public List<User> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public User findById() {
        return this.getDao().findById(entity.getId());

    }

    public User findByMail(String mail) {
        return this.getDao().findByMail(mail);
    }

    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {

        String v = (String) value;

        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Password alanı boş olamaz"));
        } else if (v.length() < 5) {
            throw new ValidatorException(new FacesMessage("Password alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }
}
