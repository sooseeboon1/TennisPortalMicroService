FROM openjdk:8-jdk-alpine
MAINTAINER See Boon Soo
ARG JAR_FILE=./target/tennis_portal_service-1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} tennis_portal_service-1.jar 
ENTRYPOINT ["java", "-jar", "tennis_portal_service-1.jar"]