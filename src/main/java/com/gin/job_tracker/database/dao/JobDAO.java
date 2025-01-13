package com.gin.job_tracker.database.dao;

import com.gin.job_tracker.database.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobDAO extends JpaRepository<Job, Long> {

    List<Job> findByUserId(Integer userId);

    Job findByIdAndUserId(Integer Id, Integer userId);

    @Query("DELETE FROM Job j WHERE j.id = :id AND j.userId = :userId")
    @Modifying
    @Transactional
    void deleteByIdAndUserId(Integer id, Integer userId);
}
