package com.ibm.graphql.graphqlexample.services.datafetcher;

import java.util.List;

import com.ibm.graphql.graphqlexample.model.Employee;
import com.ibm.graphql.graphqlexample.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllEmployeesDataFetcher implements DataFetcher<List<Employee>> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> get(DataFetchingEnvironment environment) {
        return employeeRepository.findAll();
    }

}