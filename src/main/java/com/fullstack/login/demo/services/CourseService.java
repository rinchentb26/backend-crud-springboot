package com.fullstack.login.demo.services;

import com.fullstack.login.demo.entities.Course;

public interface CourseService {
    Course saveCourse(Course course);

    Course updateCourse(Course course);

    boolean deleteCourse(Course course);
}
