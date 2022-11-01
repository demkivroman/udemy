package com.in28minutest.soap.webservices.soapcoursemanagement.soap.service;

import com.in28minutest.soap.webservices.soapcoursemanagement.soap.bean.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CourseDetailsService {
    private static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1, "Spring", "10 Steps");
        Course course2 = new Course(2, "Spring MVC", "10 Examples");
        Course course3 = new Course(3, "Spring Boot", "6K Students");
        Course course4 = new Course(4, "Maven", "Most popular maven course");
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
    }

    public Course findById(int id) {
        Optional<Course> course = courses.stream()
                .filter(el -> el.getId() == id)
                .findFirst();

        return course.get();
    }

    public List<Course> findAll() {
        return courses;
    }

    public int deleteById(int id) {
        Course course = findById(id);
        if (course != null) {
            courses.remove(course);
            return 1;
        }
        return 0;
    }
}
