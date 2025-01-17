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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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


    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView();
        User currentUser = authenticatedUserService.loadCurrentUser();
        response.addObject("title", "My Jobs");
        response.addObject("userPhoto", currentUser.getUserPhoto());
        response.setViewName("jobs/create");
        return response;
    }

    @PostMapping("delete/{jobId}")
    public ResponseEntity<String> delete(@PathVariable("jobId") Integer jobId) throws Exception {
        User currentUser = authenticatedUserService.loadCurrentUser();
        if (currentUser == null) {
            return ResponseEntity.badRequest().body("Please login first");
        }
        try {
            jobDAO.deleteByIdAndUserId(jobId, currentUser.getId());
            return ResponseEntity.ok("Succesfully deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to delete file: " + e.getMessage());
        }
    }

    @GetMapping("edit/{jobId}")
    public String editJobStage(@PathVariable("jobId") Integer jobId, @RequestParam("stage") ApplicationStage stage)  {
        Job job = jobDAO.findByIdAndUserId(jobId, authenticatedUserService.loadCurrentUser().getId());
        job.setStage(stage);
        jobDAO.save(job);
        return "redirect:/jobs/myjobs";
    }

}
