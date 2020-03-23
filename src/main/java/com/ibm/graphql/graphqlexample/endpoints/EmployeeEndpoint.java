package com.ibm.graphql.graphqlexample.endpoints;

import java.util.List;

import com.ibm.graphql.graphqlexample.model.Employee;
import com.ibm.graphql.graphqlexample.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeEndpoint {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/all")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

}