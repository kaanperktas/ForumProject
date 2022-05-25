package controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import dao.CategoryDao;
import entity.Category;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
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
 * @author CASPER
 */
@Named(value = "categoryBean")
@SessionScoped
public class CategoryBean implements Serializable {

    private Category entity;
    private CategoryDao dao;
    private List<Category> list;
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
    public CategoryBean() {
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Category();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Category();
    }

    public void delete(Category c) {
        this.getDao().delete(c);
        entity = new Category();
    }

    public void clear() {
        entity = new Category();
    }

    public boolean validate(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String v = (String) value;
        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Kategori Adı Alanı Boş Olamaz!"));
        }
        return true;
    }

    public String getName(int id) {
        Category c = this.getDao().findById(id);
        return c.getName();
    }

    public Category getEntity() {
        if (entity == null) {
            entity = new Category();
        }
        return entity;
    }

    public Category findById() {
        return this.getDao().findById(entity.getId());
    }

    public void setEntity(Category entity) {
        this.entity = entity;
    }

    public CategoryDao getDao() {
        if (dao == null) {
            dao = new CategoryDao();
        }
        return dao;
    }

    public void setDao(CategoryDao dao) {
        this.dao = dao;
    }

    public List<Category> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

}
