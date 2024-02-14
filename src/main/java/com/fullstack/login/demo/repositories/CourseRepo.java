package com.fullstack.login.demo.repositories;

import com.fullstack.login.demo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
