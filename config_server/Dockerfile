FROM openjdk:8-jdk-alpine
MAINTAINER See Boon Soo
ARG JAR_FILE=./target/config_server-1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} config_server-1.jar 
ENTRYPOINT ["java", "-jar", "config_server-1.jar"]