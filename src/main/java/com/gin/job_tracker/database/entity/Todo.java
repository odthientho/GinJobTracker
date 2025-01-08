package com.gin.job_tracker.database.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "people_id", insertable = false, updatable = false)
    private People people;

    @Column(name = "job_id")
    private Integer jobId;
}
