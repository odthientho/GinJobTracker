package com.gin.job_tracker.controller;


import com.gin.job_tracker.database.entity.User;
import com.gin.job_tracker.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping({"", "/", "/index", "/home"})
    public ModelAndView index() {
        ModelAndView response = new ModelAndView();
        response.addObject("title", "Home - Dashboard");
        User currentUser = authenticatedUserService.loadCurrentUser();
        if (currentUser != null) {
            response.addObject("userPhoto", currentUser.getUserPhoto());
        }
        response.setViewName("index");
        return response;
    }
}
