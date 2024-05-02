FROM openjdk:20-jdk

WORKDIR /app

COPY target/backend-challenge-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "backend-challenge-0.0.1-SNAPSHOT.jar"]

LABEL version="1.0"
