package edu.neu.birds.service.impl;

import edu.neu.birds.dao.UserDao;
import edu.neu.birds.entity.User;
import edu.neu.birds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Long save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public int updateUserRole(long id, String role) {
        return userDao.updateUserRole(id, role);
    }
}
