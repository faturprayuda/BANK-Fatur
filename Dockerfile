FROM openjdk:11
ADD target/bank-fatur-docker.jar bank-fatur-docker.jar
ENTRYPOINT ["java", "-jar","bank-fatur-docker.jar"]
EXPOSE 8080