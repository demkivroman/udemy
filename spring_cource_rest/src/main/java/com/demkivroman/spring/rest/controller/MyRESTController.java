package com.demkivroman.spring.rest.controller;

import com.demkivroman.spring.rest.entity.Employee;
import com.demkivroman.spring.rest.exception_handling.NoSuchEmployeeException;
import com.demkivroman.spring.rest.service.EmployeeService;
import com.demkivroman.spring.rest.util.RequestBodyJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + "in Database.");
        }

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
        if (employee == null) {
            throw new NoSuchEmployeeException(String.format("There is no employee with ID = %d in Database", id));
        }

        employeeService.deleteEmployee(id);
        return String.format("Employee with ID = %d was deleted", id);
    }

    @PostMapping(value = "/schemas/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadSchema(
            @RequestParam String schema,
            @RequestParam MultipartFile uploadFile
    ) {
        String yo = "";
        System.out.println(schema);

        return null;
    }
}
