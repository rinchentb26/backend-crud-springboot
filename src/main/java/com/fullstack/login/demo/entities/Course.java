package com.fullstack.login.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Table(name="TBL_COURSES")
public class Course {

    @SequenceGenerator(name = "courseId_sequence",sequenceName = "courseId_sequence",allocationSize = 1,initialValue = 500)
    @GeneratedValue(generator = "courseId_sequence",strategy = GenerationType.SEQUENCE)
    @Id
    private Integer courseId;
    @Column(name="name",unique = true)
    private String courseName;
    @Column(name="Domain")
    private String courseDomain;
    @Column(name="Coordinator")
    private String courseCoordinator;

    @Column(name="duration")
    private String courseDuration;

}
