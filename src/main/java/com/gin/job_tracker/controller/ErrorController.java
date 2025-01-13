package com.gin.job_tracker.controller;

import com.gin.job_tracker.database.entity.User;
import com.gin.job_tracker.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @ExceptionHandler(NoResourceFoundException.class)
    @RequestMapping(value = {"/error/404", "/404"})
    public ModelAndView error404(HttpServletRequest request) {
        ModelAndView response = new ModelAndView("error/404");
        response.addObject("title", "Error 404");
        User currentUser = authenticatedUserService.loadCurrentUser();
        if (currentUser != null) {
            response.addObject("userPhoto", currentUser.getUserPhoto());
        }
        return response;
    }

    @ExceptionHandler(Exception.class)
    @RequestMapping(value = {"/error/500", "/500"})
    public ModelAndView error500(HttpServletRequest request, Exception ex) {
        ModelAndView response = new ModelAndView("error/500");
        response.addObject("title", "Error 500");
        User currentUser = authenticatedUserService.loadCurrentUser();
        if (currentUser != null) {
            response.addObject("userPhoto", currentUser.getUserPhoto());
        }
        return response;
    }

}
