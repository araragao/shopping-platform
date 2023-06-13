# Use an official OpenJDK 17 runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /shopping-platform-app

# Copy the Maven wrapper files (.mvn, mvnw, mvnw.cmd)
COPY .mvn .mvn
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd

# Grant executable permissions to the mvnw file
RUN chmod +x mvnw

# Copy the project source code and pom.xml
COPY src/ src/
COPY pom.xml .

# Build the application with Maven and retrieve artifact name and version
RUN ./mvnw clean install -DskipTests && \
    export ARTIFACT_NAME=$(mvn -q -Dexec.executable='echo' -Dexec.args='${project.artifactId}' --non-recursive exec:exec) && \
    export ARTIFACT_VERSION=$(mvn -q -Dexec.executable='echo' -Dexec.args='${project.version}' --non-recursive exec:exec)

# Expose the default Spring Boot port
EXPOSE 8080

# Set the entrypoint command to run the Spring Boot application using the retrieved artifact name and version
ENTRYPOINT ["java", "-jar", "target/${ARTIFACT_NAME}-${ARTIFACT_VERSION}.jar"]

# Perfom health check
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 CMD curl -f http://localhost:8080/actuator/health || exit 1