FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/spring-jaeger-0.0.1-SNAPSHOT.jar spring-jaeger.jar
ADD target/spring-jaeger-0.0.1-SNAPSHOT.jar spring-jaeger.jar
ENTRYPOINT ["java","-jar","/spring-jaeger.jar"]
