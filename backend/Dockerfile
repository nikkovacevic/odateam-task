FROM openjdk:17-alpine

RUN mkdir /app
COPY target/odateam-task.jar /app
COPY src/main/resources/data.json /app

WORKDIR /app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "odateam-task.jar"]