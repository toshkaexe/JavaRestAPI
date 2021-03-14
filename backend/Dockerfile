#
# Build stage
#
FROM maven:3.5-jdk-8 AS build  
#RUN mvn -f pom.xml clean package

FROM openjdk:8
ADD /target/backend-spring-boot.jar backend-spring-boot.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "backend-spring-boot.jar"]
