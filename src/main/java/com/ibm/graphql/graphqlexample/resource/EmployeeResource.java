package com.ibm.graphql.graphqlexample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.graphql.graphqlexample.services.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeResource {

    @Autowired
    GraphQLService graphQLService;

    @PostMapping(value = "/employee")
    public ResponseEntity<Object> getAllEmployees(@RequestBody String requestString) {
        ExecutionResult executionResult = graphQLService.getGraphQL().execute(requestString);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }

}