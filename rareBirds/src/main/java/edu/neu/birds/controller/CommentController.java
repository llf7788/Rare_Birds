package edu.neu.birds.controller;

import edu.neu.birds.constant.SessionConstant;
import edu.neu.birds.controller.response.BaseResponse;
import edu.neu.birds.entity.Comment;
import edu.neu.birds.entity.User;
import edu.neu.birds.pojo.CommentInfo;
import edu.neu.birds.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/publish")
    public BaseResponse<Long> publish(HttpServletRequest request,
                                      @RequestParam(name = "birdId") long birdId,
                                      @RequestParam(name = "comment") String comment) {
        User user = (User) request.getSession().getAttribute(SessionConstant.SESSION_ATTR_USER);
        return new BaseResponse<>(commentService.save(new Comment(user.getId(), birdId, comment)));
    }

    @GetMapping(path = "/list")
    public BaseResponse<List<CommentInfo>> list(@RequestParam(name = "birdId") long birdId) {
        return new BaseResponse<>(commentService.findAllByBirdId(birdId));
    }

    @PostMapping(path = "/delete")
    public BaseResponse<Void> delete(@RequestParam(name = "id") long commentId) {
        commentService.delete(new Comment(commentId));
        return new BaseResponse<>(null);
    }
}
