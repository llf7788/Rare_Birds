package edu.neu.birds.controller;

import edu.neu.birds.constant.RoleConstant;
import edu.neu.birds.constant.SessionConstant;
import edu.neu.birds.entity.User;
import edu.neu.birds.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("error", "");
        return modelAndView;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView registerAction(@RequestParam(name = "username") String username,
                                       @RequestParam(name = "password") String password) {
        ModelAndView modelAndView = new ModelAndView("register");
        User user = userService.findUserByUsername(username);
        if (user != null) {
            modelAndView.addObject("error", "Already registered");
            return modelAndView;
        }

        userService.save(new User(username, password, RoleConstant.USER));
        modelAndView.setViewName("redirect:/bird");
        return modelAndView;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(name = "next", required = false) String next) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", "");
        return modelAndView;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView loginAction(HttpSession session,
                                    @RequestParam(name = "next", required = false) String next,
                                    @RequestParam(name = "username") String username,
                                    @RequestParam(name = "password") String password) {
        ModelAndView modelAndView = new ModelAndView("login");
        User user = userService.findUserByUsername(username);
        if (user == null) {
            modelAndView.addObject("error", "Not registered.");
            return modelAndView;
        }

        if (!user.getPassword().equals(password)) {
            modelAndView.addObject("error", "Wrong password.");
            return modelAndView;
        }

        session.setAttribute(SessionConstant.SESSION_ATTR_USER, user);
        modelAndView.setViewName("redirect:".concat(next != null ? next : "/"));
        return modelAndView;
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute(SessionConstant.SESSION_ATTR_USER);
        return new ModelAndView("redirect:/bird");
    }
}
