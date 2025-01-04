package com.gin.job_tracker.database.dao;

import com.gin.job_tracker.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    UserRole findById(Integer id);

    List<UserRole> findByUserId(Integer userId);
}
