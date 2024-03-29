FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spawn.jar
ENTRYPOINT ["java","-jar","/spawn.jar"]