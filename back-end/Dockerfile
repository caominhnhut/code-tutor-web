FROM maven:3.6.0-jdk-8-alpine as build

RUN mkdir -p /build
WORKDIR /build

COPY ./ ./

RUN mvn clean package -DskipTests=true

FROM openjdk:8

WORKDIR /build

COPY --from=build /build/ct-rest/target/ct-rest.jar ./ct-rest.jar

#ENTRYPOINT ["java", "-jar", "/build/ct-rest.jar"]