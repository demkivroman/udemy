package com.in28minutes.springboot.learnjpaandhibernate.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    private CourseJdbcRepository repository;
//    private CourseJpaRepository repository;
    private CourseSpringDataJpaRepository repository;

    @Autowired
    public CourseCommandLineRunner(CourseSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Java Clean Code jpa", "Roman Demkiv"));
        repository.save(new Course(2, "Java Clean Code2 jpa", "Roman Demkiv"));
        repository.save(new Course(3, "Java Dev Ops jpa", "Roman Demkiv"));

        repository.deleteById(1l);

        System.out.println("Results\n");
        System.out.println("======================================");

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
        System.out.println(repository.findAll());
        System.out.println(repository.findByAuthor("Roman Demkiv"));
    }
}
