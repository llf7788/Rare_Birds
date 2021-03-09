package edu.neu.birds.dao.impl;

import edu.neu.birds.dao.ImageDao;
import edu.neu.birds.entity.Image;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDaoImpl implements ImageDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Image findImageById(long id) {
        return sessionFactory.getCurrentSession().find(Image.class, id);
    }

    @Override
    public List<Image> findAllByIds(List<Long> ids) {
        return sessionFactory.getCurrentSession().byMultipleIds(Image.class).multiLoad(ids);
    }

    @Override
    public List<Image> findAllByBirdId(long birdId) {
        Query<Image> query = sessionFactory.getCurrentSession()
                .createQuery("From Image image where image.birdId = :birdId");
        query.setParameter("birdId", birdId);
        return query.list();
    }
}
