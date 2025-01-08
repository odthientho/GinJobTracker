package com.gin.job_tracker.database.dao;

import com.gin.job_tracker.database.entity.People;
import com.gin.job_tracker.database.enums.RelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleDAO extends JpaRepository<People, Long> {

    List<People> findByUserId(Integer userId);

    @Query("SELECT p FROM People p JOIN Relationship r ON r.peopleId = p.id WHERE p.userId = :userId AND r.type = :relationshipType")
    List<People> findByUserIdAndRelationshipsType(Integer userId, RelationshipType relationshipType);
}