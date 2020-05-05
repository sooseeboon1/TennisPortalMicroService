FROM openjdk:8-jdk-alpine
MAINTAINER See Boon Soo
ARG JAR_FILE=./target/TennisPortal-1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} tennis.jar 
ENTRYPOINT ["java", "-jar", "tennis.jar"]