FROM openjdk:17
COPY target/Sugar-Rush-api-1.0.jar Sugar-Rush-api-1.0.jar
ENTRYPOINT ["java", "-jar", "/Sugar-Rush-api-1.0.jar"]