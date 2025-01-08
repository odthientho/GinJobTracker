package com.gin.job_tracker.database.dao;

import com.gin.job_tracker.database.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleDAO extends JpaRepository<People, Long> {

    List<People> findByUserId(Integer userId);
}
