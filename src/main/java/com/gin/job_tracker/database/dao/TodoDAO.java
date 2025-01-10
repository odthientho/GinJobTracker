package com.gin.job_tracker.database.dao;

import com.gin.job_tracker.database.entity.Todo;
import com.gin.job_tracker.database.enums.TodoStage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoDAO extends JpaRepository<Todo, Long> {

    List<Todo> findByUserId(Integer userId);

    List<Todo> findByUserIdAndStage(Integer userId, String stage);
}
