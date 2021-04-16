FROM openjdk:8

WORKDIR /build

COPY ./ct-rest/target/ct-rest.jar ./ct-rest.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/build/ct-rest.jar"]