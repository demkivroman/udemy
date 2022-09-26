package com.romandemkiv.spring.springboot.spring_cource_springboot.dao;

import com.romandemkiv.spring.springboot.spring_cource_springboot.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
