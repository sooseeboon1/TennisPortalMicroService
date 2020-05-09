FROM openjdk:8-jdk-alpine
MAINTAINER See Boon Soo
ARG JAR_FILE=./target/eureka_server-1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} eureka_server-1.jar 
ENTRYPOINT ["java", "-jar", "eureka_server-1.jar"]