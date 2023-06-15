# Shopping platform

## Description
**This application aims to provide a REST API that allows users to get price quotations based on 
order's amount and related product.**

It supports the calculation of the order's price based on 3 different methods:
- (standard) order price
- discounted order price
- best discounted order price

Additionally, it also supports CRUD operations for `Product` and `DiscountPolicy` entities.

## Requirements
- Java 17+
- Docker Engine 19.03.0+

## Technologies
- 🫀 **Language**: [Java](https://docs.oracle.com/en/java/javase/17/)
- 🚀 **Framework**: [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- 🗄️ **Database**: [MongoDB](https://www.mongodb.com/docs/)
- 🏗️ **Build**: [Maven](https://maven.apache.org/guides/)
- 📦 **Containerization**: [Docker](https://docs.docker.com/)

## Features

### API
- [OpenAPI](https://swagger.io/specification/) and [SwaggerUI](https://swagger.io/tools/swagger-ui/) generation
- Request data validation using Jakarta validation

### Code
- Code formatting according to [Google Style Guide](https://google.github.io/styleguide/javaguide.html)
- Code coverage report generation using [JaCoCo](https://www.eclemma.org/jacoco/index.html)
- Reduced boilerplate using [Lombok](https://projectlombok.org/features/)
- Mappings generation using [MapStruct](https://mapstruct.org/)

### Database
- Database migration using [Liquibase](https://www.liquibase.org/get-started/quickstart)
- Performance optimized database queries through indexing
- Auditable database documents (createdBy, createdAt, lastModifiedBy, lastModifiedAt)

## Run application

1. Build the application
`docker build -t shopping-platform-app .`
2. Run the dependencies (i.e. mongodb)
`docker compose up`
3. Run the application
`docker run -p 8080:8080 shopping-platform-app`

- OpenAPI: [http://localhost:8080/api-docs](http://localhost:8080/api-docs)
- SwaggerUI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## FAQ

### Why is Maven not a required technology?
The project is bundled with a Maven Wrapper.
Maven Wrapper eliminates the need for developers to install Maven separately since it provides a 
lightweight script that handles all Maven interactions, ensuring consistent and hassle-free project setup.