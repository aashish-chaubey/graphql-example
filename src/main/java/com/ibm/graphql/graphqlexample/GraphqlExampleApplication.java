package com.ibm.graphql.graphqlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ibm.graphql.graphqlexample.repository")
@SpringBootApplication
public class GraphqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlExampleApplication.class, args);
	}

}
