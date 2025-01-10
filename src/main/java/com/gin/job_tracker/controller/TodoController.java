package com.gin.job_tracker.controller;

import com.gin.job_tracker.database.dao.TodoDAO;
import com.gin.job_tracker.database.dao.UserDAO;
import com.gin.job_tracker.database.entity.Job;
import com.gin.job_tracker.database.entity.Todo;
import com.gin.job_tracker.database.entity.User;
import com.gin.job_tracker.database.enums.ApplicationStage;
import com.gin.job_tracker.database.enums.TodoStage;
import com.gin.job_tracker.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoDAO todoDAO;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/mytodos")
    public ModelAndView mytodos(@RequestParam(value = "query", required = false) TodoStage query) {
        ModelAndView response = new ModelAndView();
        User currentUser = authenticatedUserService.loadCurrentUser();
        response.addObject("title", "My Todos");
        response.addObject("userPhoto", currentUser.getUserPhoto());
        response.addObject("options", TodoStage.values());

        List<Todo> todos;
        if (query != null) todos = todoDAO.findByUserIdAndStage(currentUser.getId(), query.toString());
        else todos = todoDAO.findByUserId(currentUser.getId());
        response.addObject("todos", todos);
        response.setViewName("todos/mytodos");
        return response;
    }
}
