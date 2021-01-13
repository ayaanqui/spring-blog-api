# Spring Boot REST Blog API

This repo was created so that I follow along the offical Spring docs to learn the Spring framework. This project uses MySQL as the database to store user data and blog posts.

## Setup

Before running the project make sure to follow these steps:

1. Create a directory named `resources` inside `src/main/` directory, if it does not already exist
2. Create `application.properties` file within the `src/main/resources/` directory
3. Then paste the following in `application.properties`, replacing all `{}` with the appropriate values

```properties
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:mysql://localhost:3306/{db_name}
spring.datasource.username = {db_root}
spring.datasource.password = {db_pass}
```
