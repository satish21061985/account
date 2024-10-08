# Docker Build Maven Stage
FROM maven:3-openjdk-17 AS build
# Copy folder in docker
WORKDIR /opt/app
COPY ./ /opt/app
RUN mvn clean install -DskipTests
# Run spring boot in Docker
# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
#WORKDIR /app

# Copy the jar file into the container
#COPY target/account-0.0.1-SNAPSHOT.jar app.jar
COPY --from=build /opt/app/target/account-0.0.1-SNAPSHOT.jar app.jar
# Expose the port your application runs on
EXPOSE 8081
# Define the command to run the application
ENTRYPOINT ["java","-jar","app.jar"]
