package edu.neu.birds.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.neu.birds.dao.CommentDao;
import edu.neu.birds.entity.Comment;
import edu.neu.birds.entity.User;
import edu.neu.birds.pojo.CommentInfo;
import edu.neu.birds.service.CommentService;
import edu.neu.birds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserService userService;

    @Override
    public List<CommentInfo> findAllByBirdId(long birdId) {
        List<Comment> comments = commentDao.findAllByBirdId(birdId);

        List<User> users = userService.findAll();
        Map<Long, User> idToUser = Maps.newHashMap();
        users.forEach(user -> idToUser.put(user.getId(), user));

        List<CommentInfo> commentInfos = Lists.newArrayList();
        comments.forEach(comment -> commentInfos.add(new CommentInfo(comment.getId(),
                idToUser.get(comment.getUserId()).getName(), comment.getComment())));
        return commentInfos;
    }

    @Override
    public Long save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentDao.delete(comment);
    }
}
