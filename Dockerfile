FROM openjdk:8
EXPOSE 8080
ADD target/health-app-0.0.1-SNAPSHOT.jar health-app-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/health-app-0.0.1-SNAPSHOT"]