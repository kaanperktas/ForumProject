/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.DocumentDao;
import entity.Document;
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

/**
 *
 * @author mabea
 */
@Named(value = "documentBean")
@SessionScoped
public class DocumentBean implements Serializable {

   
   private Document document;
    private DocumentDao documentDao;
    private List<Document> list;
    
    private Part file1;
    private String message;
    public DocumentBean() {
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
    public void clear(){
        document = new Document();
    }
    public void create(){
        this.getDocumentDao().create(document);
        document = new Document();
    }
    public void delete(Document c){
        this.getDocumentDao().delete(c);
        document = new Document();
    }
    public void update(){
        this.getDocumentDao().update(document);
        document = new Document();
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

    public List<Document> getList() {
        this.list = this.getDocumentDao().getList();
        return list;
    }

    public void setList(List<Document> list) {
        this.list = list;
    }
    public Document findById(){
        return this.getDocumentDao().findById(document.getId());
       
    }
    
}
