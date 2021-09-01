FROM openjdk:11-jdk-slim AS build
WORKDIR /opt/app
COPY . .
RUN ./mvnw install

FROM openjdk:11-jdk-slim
WORKDIR /opt/app
COPY --from=build /opt/app/target/backend-for-testers.jar .
ENTRYPOINT ["java", "-jar", "/opt/app/backend-for-testers.jar"]