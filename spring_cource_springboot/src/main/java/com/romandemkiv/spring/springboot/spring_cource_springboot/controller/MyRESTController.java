package com.romandemkiv.spring.springboot.spring_cource_springboot.controller;


import com.romandemkiv.spring.springboot.spring_cource_springboot.entity.Employee;
import com.romandemkiv.spring.springboot.spring_cource_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    /**
     * * Here on parameter part received JSON is automatically converted to Employee object
     * * due to dependency <groupId>com.fasterxml.jackson.core</groupId> <artifactId>jackson-databind</artifactId>
     * @param employee
     * @return
     */
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    /**
     * We use annotation @RequestBody in parameter because we want to get information about object
     * from request body.
     * @param employee
     * @return
     */
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(id);
        return String.format("Employee with ID = %d was deleted", id);
    }
}
