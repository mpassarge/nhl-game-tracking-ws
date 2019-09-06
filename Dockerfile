FROM openjdk:8-jre-alpine
COPY target/*.jar app.jar
EXPOSE 9080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]