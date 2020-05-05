FROM openjdk:8-jdk-alpine
MAINTAINER See Boon Soo
ARG JAR_FILE=./vnfm.jar
WORKDIR /opt/app
COPY ${JAR_FILE} vnfm.jar 
ENTRYPOINT ["java", "-jar", "vnfm.jar"]