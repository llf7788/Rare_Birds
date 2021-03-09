package edu.neu.birds.pojo;

import java.util.List;

public class BirdInfo {

    private long id;

    private String name;

    private String description;

    private List<ImageInfo> images;

    public BirdInfo(long id, String name, String description, List<ImageInfo> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImageInfo> getImages() {
        return images;
    }

    public void setImages(List<ImageInfo> images) {
        this.images = images;
    }
}
