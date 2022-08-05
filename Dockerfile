FROM openjdk:11-jdk-slim

COPY appinsights.jar appinsights.jar
COPY app.jar app.jar 

EXPOSE 8080
CMD java -javaagent:/appinsights.jar -jar app.jar
