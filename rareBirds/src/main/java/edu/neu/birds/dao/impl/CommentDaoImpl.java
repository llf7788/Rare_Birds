package edu.neu.birds.dao.impl;

import edu.neu.birds.dao.CommentDao;
import edu.neu.birds.entity.Comment;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Comment> findAllByBirdId(long birdId) {
        Query<Comment> query = sessionFactory.getCurrentSession()
                .createQuery("From Comment comment where comment.birdId = :birdId");
        query.setParameter("birdId", birdId);
        return query.list();
    }

    @Override
    public Long save(Comment comment) {
        return (Long) sessionFactory.getCurrentSession().save(comment);
    }

    @Override
    public void delete(Comment comment) {
        sessionFactory.getCurrentSession().delete(comment);
    }
}
