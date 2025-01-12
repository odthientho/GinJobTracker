package com.gin.job_tracker.controller;

import com.gin.job_tracker.database.dao.UserDAO;
import com.gin.job_tracker.database.entity.User;
import com.gin.job_tracker.formbean.SignUpFormBean;
import com.gin.job_tracker.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

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
    public ModelAndView signupSubmit(@Valid SignUpFormBean formUser, BindingResult bindingResult, HttpSession session) {
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

            authenticatedUserService.changeLoggedInUsername(session, formUser.getEmail(), formUser.getPassword());
            response.setViewName("redirect:/index");
        }
        return response;
    }

    @PostMapping("/updateProfilePicture")
    public ResponseEntity<String> updateProfilePicture(@RequestParam("file") MultipartFile file) throws IOException {

        log.debug("File uploaded: " + file.getOriginalFilename());
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded");
        }

        User currentUSer = authenticatedUserService.loadCurrentUser();
        if (currentUSer == null) {
            return ResponseEntity.badRequest().body("Please login first");
        }

        String fileName = currentUSer.getUsername() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')).toLowerCase();
        String pathToSave = "./src/main/webapp/pub/images/user_photo/" + fileName;
        Files.copy(file.getInputStream(), Paths.get(pathToSave), StandardCopyOption.REPLACE_EXISTING);
        String url = "/pub/images/user_photo/" + fileName;
        currentUSer.setUserPhoto(url);
        userDAO.save(currentUSer);

        return ResponseEntity.ok("File uploaded successfully: " + fileName);
    }
}
