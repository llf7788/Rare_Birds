package edu.neu.birds.pojo;

public class CommentInfo {

    private long id;

    private String username;

    private String comment;

    public CommentInfo(long id, String username, String comment) {
        this.id = id;
        this.username = username;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
