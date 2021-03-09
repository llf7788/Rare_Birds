package edu.neu.birds.controller;

import edu.neu.birds.controller.response.BaseResponse;
import edu.neu.birds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @RequestMapping(path = "/user/role", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<Integer> updateUserRole(@RequestParam(name = "id") long id,
                                             @RequestParam(name = "role") String role) {
        return new BaseResponse<>(userService.updateUserRole(id, role));
    }
}
