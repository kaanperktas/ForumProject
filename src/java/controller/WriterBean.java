/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.WriterDao;
import entity.Writer;
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
 * @author mabea
 */
@Named(value = "writerBean")
@SessionScoped
public class WriterBean implements Serializable {

    private Writer entity;
    private WriterDao dao;
    private List<Writer> list;

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

    public WriterBean() {
    }

    public boolean validateName(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {

        String v = (String) value;

        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Name alanı boş olamaz"));
        } else if (v.length() < 5) {
            throw new ValidatorException(new FacesMessage("Name alanı 5 karakterden küçük olamaz"));
        }
        return true;
    }

    public String getTitle(int id) {
        Writer c = this.getDao().findById(id);
        return c.getName();
    }

    public void clear() {
        entity = new Writer();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Writer();
    }

    public void delete(Writer c) {
        this.getDao().delete(c);
        entity = new Writer();
    }

    public Writer findById() {
        return this.getDao().findById(entity.getId());

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Writer();
    }

    public Writer getEntity() {
        if (entity == null) {
            entity = new Writer();
        }
        return entity;
    }

    public void setEntity(Writer entity) {
        this.entity = entity;
    }

    public WriterDao getDao() {
        if (dao == null) {
            dao = new WriterDao();
        }
        return dao;
    }

    public void setDao(WriterDao dao) {
        this.dao = dao;
    }

    public List<Writer> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Writer> list) {
        this.list = list;
    }

}
