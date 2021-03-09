package edu.neu.birds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(path = {"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("redirect:/bird");
    }

    @RequestMapping(path = {"/auth"})
    public ModelAndView auth() {
        return new ModelAndView("auth");
    }
}
