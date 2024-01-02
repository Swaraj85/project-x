FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.11_9

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/inventory-1.0-SNAPSHOT.jar /app

# Starting the application
CMD ["java", "-jar", "inventory-1.0-SNAPSHOT.jar"]