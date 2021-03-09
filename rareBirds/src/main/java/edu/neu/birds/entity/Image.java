package edu.neu.birds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "image",
indexes = @Index(name = "idx_bird_id", columnList = "bird_id"))
public class Image implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "bird_id")
    private long birdId;

    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getBirdId() {
        return birdId;
    }

    public void setBirdId(long bird_id) {
        this.birdId = bird_id;
    }
}
