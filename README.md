## GrapghQL starter example with Java and MySQL
In this project, we intend to show how GrapghQL could be used with MySQL as a database and access it through a Spring boot application. First we make a Spring Boot application for the endpoint and then insert GrapghQL as a layer between the client and the API. This is a pretty easy bottom up build. You can read more about graphQL in the [docs](https://graphql.org/learn/).  
It is also important to note at this point that GraphQL can be made to work with any kind of database - structured, unstructured - given we import the correct dependencies. Also, since this is just a demonstration example, we have not shown the right use case. In this case it may seem like an overkill for the application.  

### GraphQL Correct usecase

GraphQL is often the right choice when network speed and latency is the primary concern and data isn't spread across different domains but is instead centralized to one product. In this case a single network request can load many different kinds of resources at once, and selectively include only what that client needs. Particularly on mobile network connections, this can be a dramatic performance improvement.  

## How to run this project

- Clone/download this repository to your local machine
- Import the project in your Spring Tool Suite (STS) or any other IDE you are using
- Configure the application.properties file in `src/main/resources/application.properties` and edit your database name in your `spring.datasource.url` and also your MySQL username as `spring.datasource.username` and password as `spring.datasource.password`
- To follow along with the data, create a table in MySQL
```
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `job_title` varchar(100) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `notes` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
- Insert Dummy data in the table
```
INSERT INTO `employee` (`first_name`, `last_name`, `job_title`, `salary`) VALUES 
                       ('Robin', 'Jackman', 'Software Engineer', 5500),
                       ('Taylor', 'Edward', 'Software Architect', 7200),
                       ('Vivian', 'Dickens', 'Database Administrator', 6000),
                       ('Harry', 'Clifford', 'Database Administrator', 6800),
                       ('Eliza', 'Clifford', 'Software Engineer', 4750),
                       ('Nancy', 'Newman', 'Software Engineer', 5100),
                       ('Melinda', 'Clifford', 'Project Manager', 8500),
                       ('Harley', 'Gilbert', 'Software Architect', 8000);
```
- Run the application on port `8080` (By default Spring runs on an embedded Tomcat Server and you need not make any extra configurations in it)
- Use any REST client to query for the endpoint `/api/v1/employee` as a POST call and in the raw text body, pass this query
```
{
	getAllEmployees {
		id
		firstName
		lastName
		salary
	}
}
```

