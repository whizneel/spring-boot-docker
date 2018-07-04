# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine


# Make port 8091 available to the world outside this container
EXPOSE 8091

# The application's jar file
ARG JAR_FILE=target/gs-spring-boot-docker-0.1.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} main.jar

## Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/main.jar"]