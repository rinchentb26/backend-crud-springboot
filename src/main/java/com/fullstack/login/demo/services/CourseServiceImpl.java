package com.fullstack.login.demo.services;

import com.fullstack.login.demo.entities.Course;
import com.fullstack.login.demo.repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Course existingCourse = courseRepo.findById(course.getCourseId()).orElse(null);
        if(existingCourse != null)
        {
                if(Objects.nonNull(course.getCourseName()) && !course.getCourseName().isEmpty())
                {
                    existingCourse.setCourseName(course.getCourseName());
                }
            if(Objects.nonNull(course.getCourseDuration()) && !course.getCourseDuration().isEmpty())
            {
                existingCourse.setCourseDuration(course.getCourseDuration());
            }
            if(Objects.nonNull(course.getCourseDomain()) && !course.getCourseDomain().isEmpty())
            {
                existingCourse.setCourseDomain(course.getCourseDomain());
            }
            if(Objects.nonNull(course.getCourseCoordinator()) && !course.getCourseCoordinator().isEmpty())
            {
                existingCourse.setCourseCoordinator(course.getCourseCoordinator());
            }
               return  courseRepo.save(existingCourse);
        }
        else{
            return null;
        }
    }

    @Override
    public boolean deleteCourse(Course course) {
        Course existingCourse = courseRepo.findById(course.getCourseId()).orElse(null);
        if(existingCourse !=null && existingCourse.getCourseName().equals(course.getCourseName()))
        {
            courseRepo.delete(existingCourse);
            return true;
        }
        return false;


    }

    @Override
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }
}
