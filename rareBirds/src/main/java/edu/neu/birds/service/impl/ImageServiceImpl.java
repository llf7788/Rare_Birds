package edu.neu.birds.service.impl;

import edu.neu.birds.dao.ImageDao;
import edu.neu.birds.entity.Image;
import edu.neu.birds.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao imageDao;

    @Override
    public Image findImageById(long id) {
        return imageDao.findImageById(id);
    }

    @Override
    public List<Image> findAllByIds(List<Long> ids) {
        return imageDao.findAllByIds(ids);
    }

    @Override
    public List<Image> findAllByBirdId(long birdId) {
        return imageDao.findAllByBirdId(birdId);
    }
}
