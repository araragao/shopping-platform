# Shopping platform

## Description
*This application aims to provide a REST API that allows users to get price quotations based on 
order's amount and related product.*

It supports the calculation of the order's price based on 3 different criteria:
- standard order price
- discounted order price (for a specific discount policy)
- best order price

Additionally, it also supports CRUD operations for `Product` and `DiscountPolicy` entities.

## Requirements
- Java 17+
- Docker Engine 19.03.0+

## Technologies
- 🫀 *Language*: [Java](https://docs.oracle.com/en/java/javase/17/)
- 🚀 *Framework*: [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- 🗄️ *Database*: [MongoDB](https://www.mongodb.com/docs/)
- 🏗️ *Build*: [Maven](https://maven.apache.org/guides/)
- 📦 *Containerization*: [Docker](https://docs.docker.com/)

## Features
- Code formatting according to [Google Style Guide](https://google.github.io/styleguide/javaguide.html)
- [OpenAPI](https://swagger.io/specification/) and [SwaggerUI](https://swagger.io/tools/swagger-ui/) generation
- Code coverage report generation
- Auditable database documents (createdBy, createdAt, lastModifiedBy, lastModifiedAt)

## Run application and external dependencies
Docker Compose is used to achieve this purpose.
The application is containerized according to the respective Dockerfile and started alongside a MongoDB instance.

`docker compose up`

## Run application

### Build
`docker build -t shopping-platform-app .`

### Run
`docker run -p 8080:8080 shopping-platform-app`

## FAQ

### Why is Maven not a required technology?
The project is bundled with a Maven Wrapper.
Maven Wrapper eliminates the need for developers to install Maven separately since it provides a 
lightweight script that handles all Maven interactions, ensuring consistent and hassle-free project setup.