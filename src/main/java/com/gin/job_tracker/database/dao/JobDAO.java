package com.gin.job_tracker.database.dao;

import com.gin.job_tracker.database.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDAO extends JpaRepository<Job, Long> {

    List<Job> findByUserId(Integer userId);
}
