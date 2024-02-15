package com.fullstack.login.demo.services;

import com.fullstack.login.demo.entities.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);

    Course updateCourse(Course course);

    boolean deleteCourse(Course course);

    List<Course> getCourses();
}
