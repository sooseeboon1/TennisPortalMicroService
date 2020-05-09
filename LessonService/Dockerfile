FROM openjdk:8-jdk-alpine
MAINTAINER See Boon Soo
ARG JAR_FILE=./target/lesson_service-1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} lesson_service-1.jar 
ENTRYPOINT ["java", "-jar", "lesson_service-1.jar"]