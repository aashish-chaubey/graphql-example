package com.ibm.graphql.graphqlexample.services.datafetcher;

import com.ibm.graphql.graphqlexample.model.Employee;
import com.ibm.graphql.graphqlexample.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class EmployeeDataFetcher implements DataFetcher<Employee> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee get(DataFetchingEnvironment environment) {
        Integer id = environment.getArgument("id");
        return employeeRepository.getOne(id);
    }

}