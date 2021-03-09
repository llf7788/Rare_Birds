package edu.neu.birds.dao.impl;

import edu.neu.birds.dao.UserDao;
import edu.neu.birds.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(User user) {
        return (Long) sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findUserById(long id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM User user").list();
    }

    @Override
    public User findUserByUsername(String username) {
        Query<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User user where user.name = :username");
        query.setParameter("username", username);
        List<User> users = query.list();
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public int updateUserRole(long id, String role) {
        return sessionFactory.getCurrentSession()
                .createQuery("UPDATE User user SET user.role = :role WHERE user.id = :id")
                .setParameter("role", role)
                .setParameter("id", id)
                .executeUpdate();
    }
}
