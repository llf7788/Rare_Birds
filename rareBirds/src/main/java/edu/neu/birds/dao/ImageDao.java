package edu.neu.birds.dao;

import edu.neu.birds.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao {

    public Image findImageById(long id);

    public List<Image> findAllByIds(List<Long> ids);

    public List<Image> findAllByBirdId(long birdId);

}
