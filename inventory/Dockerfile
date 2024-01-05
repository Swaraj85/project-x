FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.11_9

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/*.jar /app/app.jar

# Starting the application
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/app/app.jar"]