package edu.neu.birds.service;

import edu.neu.birds.entity.Image;

import java.util.List;

public interface ImageService {

    public Image findImageById(long id);

    public List<Image> findAllByIds(List<Long> ids);

    public List<Image> findAllByBirdId(long birdId);

}
