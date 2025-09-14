# Use Java 17 base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy Maven files first for caching dependencies
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the Spring Boot JAR file
RUN ./mvnw clean package -DskipTests

# Expose application port
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
