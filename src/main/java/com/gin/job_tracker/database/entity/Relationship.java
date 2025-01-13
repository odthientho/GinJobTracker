package com.gin.job_tracker.database.entity;


import com.gin.job_tracker.database.enums.RelationshipType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "relationships")
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "people_id")
    private Integer peopleId;

    @ManyToOne
    @JoinColumn(name = "people_id", insertable = false, updatable = false)
    private People people;

    @Column(name = "job_id")
    private Integer jobId;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private Job job;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RelationshipType type;
}
