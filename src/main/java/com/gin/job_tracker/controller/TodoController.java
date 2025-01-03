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
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/mytodos")
    public ModelAndView mytodos() {
        ModelAndView response = new ModelAndView();
        response.addObject("title", "My Todos");
        response.setViewName("index");
        return response;
    }
}
