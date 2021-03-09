package edu.neu.birds.dao.impl;

import edu.neu.birds.dao.BirdDao;
import edu.neu.birds.entity.Bird;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BirdDaoImpl implements BirdDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Bird findBirdById(long id) {
        return sessionFactory.getCurrentSession().find(Bird.class, id);
    }

    @Override
    public List<Bird> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Bird bird").list();
    }
}
