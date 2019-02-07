#Base image containing the JRE
FROM openjdk:8-jdk-alpine

#Maintainer
LABEL maintainer="pratik.murali@gmail.com"

#Volume
VOLUME /tmp

#External Port
EXPOSE 8080

#Spring Boot Microservice jar file
#ARG JAR_FILE = /build/libs/paxos-0.0.1-SNAPSHOT.jar

#Add jar to container
ADD /build/libs/messages-1.0.jar messages.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","messages.jar"]