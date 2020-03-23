package com.ibm.graphql.graphqlexample.services;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import com.ibm.graphql.graphqlexample.services.datafetcher.AllEmployeesDataFetcher;
import com.ibm.graphql.graphqlexample.services.datafetcher.EmployeeDataFetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

    @Value("classpath:schema.graphql")
    Resource resource;
    private GraphQL graphQL;

    @Autowired
    private AllEmployeesDataFetcher allEmployeesDataFetcher;
    @Autowired
    private EmployeeDataFetcher employeeDataFetcher;

    @PostConstruct
    public void loadSchema() throws IOException {
        // get the schema
        File fileSchema = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(fileSchema);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("getAllEmployees", allEmployeesDataFetcher)
                        .dataFetcher("getEmployee", employeeDataFetcher))
                .build();
    }

    /**
     * @return the graphQL
     */
    public GraphQL getGraphQL() {
        return graphQL;
    }

}