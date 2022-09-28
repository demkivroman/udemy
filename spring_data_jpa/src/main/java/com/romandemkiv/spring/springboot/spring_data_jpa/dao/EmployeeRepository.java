package com.romandemkiv.spring.springboot.spring_data_jpa.dao;

import com.romandemkiv.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Our repository extends from SpringBoot JpaRepository where generic are
 * first parameter ENTITY which we're working with and second is type of entity id. In our case it's int so we
 * should assign wrapper class Integer
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /**
     * SpringBoot gives us the opportunity construct any queries and use realization from under the hood.
     * In this case we want to retrieve all employees by name so we need indicate name as parameter
     * @param name
     * @return
     */
    public List<Employee> findAllByName(String name);
}
