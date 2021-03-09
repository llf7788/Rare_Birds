package edu.neu.birds.controller;

import edu.neu.birds.constant.SessionConstant;
import edu.neu.birds.pojo.BirdInfo;
import edu.neu.birds.service.BirdService;
import edu.neu.birds.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/bird")
public class BirdController {

    @Autowired
    private BirdService birdService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("bird");
        List<BirdInfo> birdInfos = birdService.list();
        modelAndView.addObject("birdInfos", birdInfos);
        return modelAndView;
    }

    @RequestMapping(path = "/detail")
    public ModelAndView single(HttpSession session,
                               @RequestParam(name = "id") long birdId) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("birdInfo", birdService.find(birdId));

        if (session.getAttribute(SessionConstant.SESSION_ATTR_USER) != null) {
            modelAndView.addObject("comments", commentService.findAllByBirdId(birdId));
        }
        return modelAndView;
    }
}
