FROM ubuntu:22.04

# install ping utilities
RUN apt-get update -y
RUN apt-get install -y iputils-ping
RUN apt-get install openjdk-11-jdk -y

# Copy the jar and script file into our app
COPY ./target/*.jar /app/app.jar
COPY run.sh /app/run.sh

# Setting up work directory
WORKDIR /app

# Make the shell script executable
RUN chmod +x run.sh

# Starting the application
#ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/app/app.jar"]
#CMD ["./run.sh"]
ENTRYPOINT [ "sh", "-c", "./run.sh" ]