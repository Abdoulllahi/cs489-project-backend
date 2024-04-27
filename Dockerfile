# Use AdoptOpenJDK 11 as the base image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/cs489-project-backend.jar /app

# Expose port 8080
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "cs489-project-backend.jar"]
