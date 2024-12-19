package com.gin.job_tracker.controller;

import com.gin.job_tracker.database.dao.UserDAO;
import com.gin.job_tracker.database.entity.User;
import com.gin.job_tracker.formbean.LoginFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login");
        return response;
    }

    @GetMapping("/submit")
    public ModelAndView submit(@Valid LoginFormBean user, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        log.info(user.toString());
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.error(error.getDefaultMessage());
            }
            response.setViewName("login");
            response.addObject("error", bindingResult.getAllErrors().get(0).getDefaultMessage());
            response.addObject("user", user);
        } else {
            User checkingUser = userDAO.findByEmail(user.getEmail());
            if (checkingUser == null) {
                // no email
                response.setViewName("login");
            } else {
                if (user.getPassword().equals(checkingUser.getPassword())) {
                    response.setViewName("redirect:/index");
                } else {
                    // not correct password
                    response.setViewName("login");
                }
            }
        }
        return response;
    }
}
