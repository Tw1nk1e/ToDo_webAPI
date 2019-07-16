FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/graphql-java-tools-example-0.0.1-SNAPSHOT.jar target/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]