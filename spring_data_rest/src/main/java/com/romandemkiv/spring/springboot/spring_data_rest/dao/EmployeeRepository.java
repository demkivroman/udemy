package com.romandemkiv.spring.springboot.spring_data_rest.dao;


import com.romandemkiv.spring.springboot.spring_data_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Our repository extends from SpringBoot JpaRepository where generic are
 * first parameter ENTITY which we're working with and second is type of entity id. In our case it's int so we
 * should assign wrapper class Integer
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
