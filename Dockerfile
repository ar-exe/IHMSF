# Start with a base image containing Java runtime
FROM maven:3.8.1-openjdk-11-slim as build

# Make source folder
RUN mkdir -p /workspace
WORKDIR /workspace

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Build all dependencies for offline use
RUN ./mvnw dependency:go-offline -B

# Copy your other files
COPY src src

# Build the project
RUN ./mvnw clean package

# Start with a base image containing Java runtime
FROM openjdk:11-jre-slim

# Add Maintainer Info
LABEL maintainer="NARCO"

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Set application's JAR file
ARG JAR_FILE=target/*.jar

# Add the application's JAR file to the container
COPY --from=build /workspace/${JAR_FILE} app.jar

# Run the JAR file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]