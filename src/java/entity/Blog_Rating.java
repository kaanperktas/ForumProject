

package entity;


public class Blog_Rating {
    private int id;
    private Blog blog;
    private int total_score;

    public Blog_Rating(int id, Blog blog, int total_score) {
        this.id = id;
        this.blog = blog;
        this.total_score = total_score;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    

    public Blog_Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }
    
}
