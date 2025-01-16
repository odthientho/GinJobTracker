package com.gin.job_tracker.controller;

import com.gin.job_tracker.database.dao.PeopleDAO;
import com.gin.job_tracker.database.entity.Job;
import com.gin.job_tracker.database.entity.People;
import com.gin.job_tracker.database.entity.User;
import com.gin.job_tracker.database.enums.RelationshipType;
import com.gin.job_tracker.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleDAO peopleDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/mypeople")
    public ModelAndView mypeople(@RequestParam(value = "query", required = false) RelationshipType query) {
        ModelAndView response = new ModelAndView();
        User currentUser = authenticatedUserService.loadCurrentUser();
        response.addObject("title", "My People");
        response.addObject("userPhoto", currentUser.getUserPhoto());
        response.addObject("options", RelationshipType.values());
        List<People> people;
        if (query != null) people = peopleDAO.findByUserIdAndRelationshipsType(currentUser.getId(), query);
        else people= peopleDAO.findByUserId(currentUser.getId());
        response.addObject("people", people);
        response.setViewName("people/mypeople");
        return response;
    }
}
