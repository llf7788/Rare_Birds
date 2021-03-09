package edu.neu.birds.service;

import edu.neu.birds.entity.Comment;
import edu.neu.birds.pojo.CommentInfo;

import java.util.List;

public interface CommentService {

    public List<CommentInfo> findAllByBirdId(long birdId);

    public Long save(Comment comment);

    public void delete(Comment comment);

}
