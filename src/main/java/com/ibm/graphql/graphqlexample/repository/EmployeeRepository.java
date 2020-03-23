package com.ibm.graphql.graphqlexample.repository;

import com.ibm.graphql.graphqlexample.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}