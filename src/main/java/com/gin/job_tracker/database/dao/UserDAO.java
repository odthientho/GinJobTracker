package com.gin.job_tracker.database.dao;

import com.gin.job_tracker.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(@Param("email") String email);
}
