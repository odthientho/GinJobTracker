package com.gin.job_tracker.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @GetMapping({"", "/", "/index", "/home"})
    public ModelAndView index() {
        ModelAndView response = new ModelAndView();
        response.addObject("title", "Home - Dashboard");
        response.setViewName("index");
        return response;
    }

    @GetMapping("/404")
    public ModelAndView notFound() {
        ModelAndView response = new ModelAndView();
        response.setViewName("404");
        return response;
    }
}