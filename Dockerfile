FROM openjdk:17-jdk-slim

WORKDIR /shopping-platform-app

COPY . .

RUN ./mvnw clean install -DskipTests

ENTRYPOINT ["java", "-jar", "target/shopping-platform-1.0.0.jar"]

HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 CMD curl -f http://localhost:8080/actuator/health || exit 1

EXPOSE 8080