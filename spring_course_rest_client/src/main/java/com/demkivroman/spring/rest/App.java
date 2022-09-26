package com.demkivroman.spring.rest;

import com.demkivroman.spring.rest.configuration.MyConfig;
import com.demkivroman.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee empBuId = communication.getEmployee(1);
//        System.out.println(empBuId);

//        Employee employee = new Employee("Sveta", "Sokolova", "IT", 1900);
//        employee.setId(9);
//        communication.saveEmployee(employee);

        communication.deleteEmployee(9);
    }
}
