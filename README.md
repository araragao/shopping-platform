# Shopping platform

## Description
**This application aims to provide a REST API that allows users to get price quotations based on 
order's amount, related product and discount policy..**

It supports the calculation of the order's price based on 3 different methods:
- (standard) order price
- discounted order price
- best discounted order price

Additionally, it also supports CRUD operations for `Product` and `DiscountPolicy` entities.

## Requirements
- Java 17+
- Docker Engine 20.10.0+

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
- Database migration using [Mongock](https://docs.mongock.io/)
- Performance optimized database queries through indexing
- Auditable database documents (createdBy, createdAt, lastModifiedBy, lastModifiedAt)

## Run application

`docker compose up`

- OpenAPI: [http://localhost:8080/api-docs](http://localhost:8080/api-docs)
- SwaggerUI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## FAQ

### Why is Maven not a required technology?
The project is bundled with a `Maven Wrapper`.
`Maven Wrapper` eliminates the need for developers to install Maven separately since it provides a 
lightweight script that handles all Maven operations, ensuring consistents project setup.

### Why is MongoDB not a required technology?
MongoDB is not a required technology since it is added as a dependency in the `docker-compose.yml`.

Additionally, whenever the application is run via .jar file or IDE, MongoDB is also provided as a 
Docker image, defined in the `/docker-compose/mongodb/common.yml` file and started alongside the 
application by leveraging `spring-boot-docker-compose`, available from `Spring Boot 3.1` version.

### Why is dockerized mongodb split in two different files, local and test? 
Unfortunately, running containers in a local environment in isolation from containers running in 
tests is not so easy to configure. 
That happens because `spring-boot-docker-compose` tries to find out if it should start new 
containers with only a simple check of results from `docker compose ps` command. 
If there are any services already running, it won’t spin up new containers for us, which will result
in tests connected to the container started for local development.
The solution was to create separate docker-compose.yml files for each environment (local and test) 
and to put them in `docker-compose` folder.

From [SoftwareMill Tech Blog](https://softwaremill.com/do-you-still-need-testcontainers-with-spring-boot-3-1/)