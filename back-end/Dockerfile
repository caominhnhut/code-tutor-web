FROM maven:3.6.0-jdk-8-alpine as build

RUN mkdir -p /build
WORKDIR /build

COPY back-end ./back-end

RUN mvn clean package -DskipTests=true

FROM openjdk:8

WORKDIR /build

COPY --from=build /build/back-end/ct-rest/target/ct-rest.jar ./

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/build/ct-rest.jar"]