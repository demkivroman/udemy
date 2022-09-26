package com.demkiv.spring.mvc_hibernaye_aop.service;

import com.demkiv.spring.mvc_hibernaye_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
