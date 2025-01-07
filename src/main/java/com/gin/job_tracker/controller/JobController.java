package com.gin.job_tracker.controller;

import com.gin.job_tracker.database.dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/myjobs")
    public ModelAndView myjobs() {
        ModelAndView response = new ModelAndView();
        response.addObject("title", "My Jobs");
        response.setViewName("jobs/myjobs");
        return response;
    }
}
