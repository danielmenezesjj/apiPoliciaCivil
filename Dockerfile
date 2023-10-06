# Use a base image with OpenJDK
FROM openjdk:latest

# Set the working directory
WORKDIR /app

# Copy wait-for-it script
COPY wait-for-it.sh /app/wait-for-it.sh

# Make the script executable
RUN chmod +x /app/wait-for-it.sh

# Copy your application JAR file
COPY target/apiPoliciaCivil-0.0.1-SNAPSHOT.jar /app/apiPoliciaCivil.jar

# Set the entry point to use wait-for-it before starting the application
ENTRYPOINT ["/app/wait-for-it.sh", "mysql-api:3306", "--", "java", "-jar", "apiPoliciaCivil.jar"]
