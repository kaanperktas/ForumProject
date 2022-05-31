/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.BlogDao;
import entity.Blog;
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

/**
 *
 * @author Gökhan
 */
@Named(value = "blogBean")
@SessionScoped

public class BlogBean implements Serializable {

    private int page = 0;
    private int pageSize = 5;
    private int pageCount;
    private Blog entity;
    private BlogDao dao;
    private List<Blog> list;
    private Part file1;
    private String message;

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

    public BlogBean() {
    }

    public String getTitle(int id) {
        Blog c = this.getDao().findById(id);
        return c.getTitle();
    }

    public void clear() {
        entity = new Blog();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Blog();
    }

    public void delete(Blog c) {
        this.getDao().delete(c);
        entity = new Blog();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Blog();
    }

    public Blog getEntity() {
        if (entity == null) {
            entity = new Blog();
        }
        return entity;
    }

    public void setEntity(Blog entity) {
        this.entity = entity;
    }

    public BlogDao getDao() {
        if (dao == null) {
            dao = new BlogDao();
        }
        return dao;
    }

    public void setDao(BlogDao dao) {
        this.dao = dao;
    }

    public List<Blog> getList() {
        this.list = this.getDao().getList(page,pageSize);
        return list;
    }

    public void setList(List<Blog> list) {
        this.list = list;
    }

    public Blog findById() {
        return this.getDao().findById(entity.getId());

    }

    public boolean validateTitle(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {

        String v = (String) value;

        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Title alanı boş olamaz"));
        } else if (v.length() < 5) {
            throw new ValidatorException(new FacesMessage("Title alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }

}
