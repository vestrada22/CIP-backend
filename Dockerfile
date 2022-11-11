FROM openjdk:8-jdk-alpine
MAINTAINER cippoli
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]