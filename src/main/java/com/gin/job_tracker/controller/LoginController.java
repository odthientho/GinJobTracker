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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.addObject("title", "Login");
        response.setViewName("login/login");
        return response;
    }
//
//    @PostMapping("/submit")
//    public ModelAndView submit(@Valid LoginFormBean user, BindingResult bindingResult) {
//        ModelAndView response = new ModelAndView();
//        log.info(user.toString());
//        if (bindingResult.hasErrors()) {
//            for (ObjectError error : bindingResult.getAllErrors()) {
//                log.error(error.getDefaultMessage());
//            }
//            response.setViewName("login");
//            response.addObject("error", bindingResult.getAllErrors().get(0).getDefaultMessage());
//            response.addObject("user", user);
//        } else {
//            User checkingUser = userDAO.findByEmail(user.getEmail());
//            if (checkingUser == null) {
//                // TODO: no email
//                response.setViewName("login");
//            } else {
//                if (user.getPassword().equals(checkingUser.getPassword())) {
//                    response.setViewName("redirect:/index");
//                } else {
//                    // TODO: not correct password
//                    response.setViewName("login");
//                }
//            }
//        }
//        return response;
//    }
}
