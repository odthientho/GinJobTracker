package com.gin.job_tracker.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "details")
    private String details;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "stage")
    private String stage;

    @ManyToOne
    @JoinColumn(name = "people_id", insertable = false, updatable = false)
    private People people;

    @Column(name = "people_id")
    private Integer peopleId;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private Job job;

    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "user_id")
    private Integer userId;
}
