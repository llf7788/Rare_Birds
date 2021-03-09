package edu.neu.birds.dao;

import edu.neu.birds.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    public List<Comment> findAllByBirdId(long birdId);

    public Long save(Comment comment);

    public void delete(Comment comment);
}
