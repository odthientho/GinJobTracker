package com.gin.job_tracker.controller;

import com.gin.job_tracker.database.dao.UserDAO;
import com.gin.job_tracker.database.entity.User;
import com.gin.job_tracker.formbean.SignUpFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.addObject("title", "Log In");
        response.setViewName("login/login");
        return response;
    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView();
        response.addObject("title", "Sign Up");
        response.setViewName("login/signup");
        return response;
    }

    @PostMapping("/signupSubmit")
    public ModelAndView signupSubmit(@Valid SignUpFormBean formUser, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.addObject("title", "Sign Up");
            response.addObject("formUser", formUser);
            response.addObject("error", bindingResult.getAllErrors().get(0).getDefaultMessage());
            response.setViewName("login/signup");
        } else {
            User user = new User();

            user.setEmail(formUser.getEmail());
            user.setPassword(passwordEncoder.encode(formUser.getPassword()));
            user.setUsername(formUser.getUsername());

            userDAO.save(user);
            response.setViewName("redirect:/index");
        }
        return response;
    }
}
