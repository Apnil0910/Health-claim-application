FROM openjdk:8
EXPOSE 8080
ADD target/health-app.jar health-app-docker.jar 
ENTRYPOINT ["java","-jar","/health-app-docker"]
