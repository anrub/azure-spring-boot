FROM openjdk:11-jdk-slim

COPY appinsights.jar appinsights.jar
COPY app.jar app.jar 

CMD java -javaagent:/appinsights.jar -jar app.jar
