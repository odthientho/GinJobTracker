package com.gin.job_tracker.controller;

import com.gin.job_tracker.database.dao.JobDAO;
import com.gin.job_tracker.database.entity.Job;
import com.gin.job_tracker.database.entity.User;
import com.gin.job_tracker.database.enums.ApplicationStage;
import com.gin.job_tracker.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobDAO jobDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/myjobs")
    public ModelAndView myjobs(@RequestParam(value = "query", required = false) ApplicationStage query) {
        ModelAndView response = new ModelAndView();
        User currentUser = authenticatedUserService.loadCurrentUser();
        List<Job> jobs = jobDAO.findByUserId(currentUser.getId());
        response.addObject("title", "My Jobs");
        response.addObject("userPhoto", currentUser.getUserPhoto());
        response.addObject("options", ApplicationStage.values());
        if (query != null) {
            List<Job> filteredJobs = jobs.stream().filter(job -> job.getStage().equals(query)).toList();
            response.addObject("jobs", filteredJobs);
        } else response.addObject("jobs", jobs);
        response.setViewName("jobs/myjobs");
        return response;
    }

    @GetMapping("/view/{jobId}")
    public ModelAndView view(@PathVariable("jobId") Integer jobId) {
        ModelAndView response = new ModelAndView();
        User currentUser = authenticatedUserService.loadCurrentUser();
        Job job = jobDAO.findByIdAndUserId(jobId, currentUser.getId());
        response.addObject("title", "My Jobs");
        response.addObject("userPhoto", currentUser.getUserPhoto());
        response.addObject("job", job);
        response.setViewName("jobs/view");
        return response;
    }

}
