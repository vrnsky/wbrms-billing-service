FROM openjdk:17-jdk-slim
COPY target/wbrms-billing-service.jar service.jar
CMD java $JAVA_OPTS -jar /service.jar
EXPOSE 8080
