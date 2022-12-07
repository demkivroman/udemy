package com.in28minutes.springboot.learnjpaandhibernate.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    private CourseJdbcRepository repository;
    private CourseJpaRepository repository;

    @Autowired
    public CourseCommandLineRunner(CourseJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Java Clean Code jpa", "Roman Demkiv"));
        repository.insert(new Course(2, "Java Clean Code2 jpa", "Roman Demkiv"));
        repository.insert(new Course(3, "Java Dev Ops jpa", "Roman Demkiv"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
