# Use official OpenJDK 17 image as base
FROM openjdk:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/BloggingProject-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar file when container starts
ENTRYPOINT ["java", "-jar", "app.jar"]