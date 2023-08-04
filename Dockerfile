FROM openjdk:17
COPY target/*.jar Sugar-Rush-api.jar
ENTRYPOINT ["java", "-jar", "/Sugar-Rush-api.jar"]