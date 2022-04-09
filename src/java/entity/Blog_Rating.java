

package entity;


public class Blog_Rating {
    private int id;
    private int blog_id;
    private int total_score;

    public Blog_Rating(int id, int blog_id, int total_score) {
        this.id = id;
        this.blog_id = blog_id;
        this.total_score = total_score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }
    
}
