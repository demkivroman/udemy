package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private final JdbcTemplate jdbcTemplate;
    private static String INSERT_QUERY = "insert into course(id, name, author) values(1, 'learn AWS', 'in28minutes');";

    @Autowired
    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert() {
        jdbcTemplate.update(INSERT_QUERY);
    }


}
