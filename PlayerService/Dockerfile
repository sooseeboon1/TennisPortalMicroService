FROM openjdk:8-jdk-alpine
MAINTAINER See Boon Soo
ARG JAR_FILE=./target/player_service-1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} player_service-1.jar 
ENTRYPOINT ["java", "-jar", "player_service-1.jar"]