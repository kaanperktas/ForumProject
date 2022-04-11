package entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;


public class Blog {
    private int id;
    private String title;
    private String content;
    private String image;
    private Timestamp create_date;
    private Category category;
    private Boolean status;
    private Writer writer;
    
    public Blog(int id, String title, String content, String image, Timestamp create_date, Category category, Boolean status, Writer writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.create_date =  create_date;
        this.category = category;
        this.status = status;
        this.writer = writer;
    }
    public int getId() {
        return id;
    }

    public Blog() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + Objects.hashCode(this.content);
        hash = 73 * hash + Objects.hashCode(this.image);
        hash = 73 * hash + Objects.hashCode(this.create_date);
        hash = 73 * hash + Objects.hashCode(this.category);
        hash = 73 * hash + Objects.hashCode(this.status);
        hash = 73 * hash + Objects.hashCode(this.writer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Blog other = (Blog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.create_date, other.create_date)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return Objects.equals(this.writer, other.writer);
    }

    
}