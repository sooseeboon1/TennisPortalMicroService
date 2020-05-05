FROM tomcat
MAINTAINER See Boon Soo
ARG JAR_FILE=./vnfm.war
WORKDIR /usr/local/tomcat/webapps
COPY ${JAR_FILE} vnfm.war
CMD ["catalina.sh", "run"]
