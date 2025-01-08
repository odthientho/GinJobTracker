package com.gin.job_tracker.database.entity;

import com.gin.job_tracker.database.enums.ApplicationStage;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "office_type")
    private String officeType;

    @Column(name = "role_type")
    private String roleType;

    @Column(name = "location")
    private String location;

    @Column(name = "link")
    private String link;

    @Column(name = "stage")
    @Enumerated(EnumType.STRING)
    private ApplicationStage stage;

    @Column(name = "resume")
    private String resume;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_logo")
    private String companyLogo;

    @Column(name = "user_id")
    private Integer userId;

}
