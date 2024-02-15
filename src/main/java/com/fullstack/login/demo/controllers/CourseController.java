package com.fullstack.login.demo.controllers;

import com.fullstack.login.demo.entities.Course;
import com.fullstack.login.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/courses/save")
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/courses/update")
    public ResponseEntity<String> updateCourse(@RequestBody Course course){

        Course savedCourse = courseService.updateCourse(course);
        if(savedCourse == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found!");
        }
        return ResponseEntity.ok("Course Saved!");
    }
    @DeleteMapping("/courses/delete")
    public ResponseEntity<String> deleteCourse(@RequestBody Course course)
    {
      boolean isDeleted = courseService.deleteCourse(course);
        if(isDeleted)
            return ResponseEntity.ok("Course deleted!");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
    }
    @GetMapping("/courses/all")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

}
