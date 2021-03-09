package edu.neu.birds.dao;

import edu.neu.birds.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public Long save(User user);

    public User findUserById(long id);

    public List<User> findAll();

    public User findUserByUsername(String username);

    public int updateUserRole(long id, String role);

}
