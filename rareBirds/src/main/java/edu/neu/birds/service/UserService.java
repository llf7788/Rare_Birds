package edu.neu.birds.service;

import edu.neu.birds.entity.User;

import java.util.List;

public interface UserService {

    public Long save(User user);

    public User findUserById(long id);

    public List<User> findAll();

    public User findUserByUsername(String username);

    public int updateUserRole(long id, String role);

}
