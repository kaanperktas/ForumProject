
package entity;

import java.util.Date;
import java.util.Objects;


public class Blog {
    private int id;
    private String title;
    private String content;
    private String image;
    private Date create_date;
    private int category_id;
    private Boolean status;
    private int writer_id;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.title);
        hash = 19 * hash + Objects.hashCode(this.content);
        hash = 19 * hash + Objects.hashCode(this.image);
        hash = 19 * hash + Objects.hashCode(this.create_date);
        hash = 19 * hash + this.category_id;
        hash = 19 * hash + Objects.hashCode(this.status);
        hash = 19 * hash + this.writer_id;
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
        if (this.category_id != other.category_id) {
            return false;
        }
        if (this.writer_id != other.writer_id) {
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
        return Objects.equals(this.status, other.status);
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

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }

    public Blog(int id, String title, String content, String image, Date create_date, int category_id, Boolean status, int writer_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.create_date = create_date;
        this.category_id = category_id;
        this.status = status;
        this.writer_id = writer_id;
    }
}
