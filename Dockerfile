FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY . /path/to/dir/in/image
ENTRYPOINT ["java","-jar","/app.jar"]
