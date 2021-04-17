FROM openjdk:8

WORKDIR /build

COPY ./ct-rest/target/ct-rest.jar ./ct-rest.jar

#ENTRYPOINT ["java", "-jar", "/build/ct-rest.jar"]