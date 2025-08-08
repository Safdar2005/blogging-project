# ---------- Stage 1: Build the JAR ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy Maven config and source code
COPY pom.xml .
COPY src ./src

# Build the project without running tests
RUN mvn clean package -DskipTests

# ---------- Stage 2: Run the JAR ----------
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy built JAR from previous stage
COPY --from=build /app/target/BloggingProject-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
