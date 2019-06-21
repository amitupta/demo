FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/bird.jar

COPY ${JAR_FILE} bird.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bird.jar"]
