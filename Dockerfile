# Use the official Maven image to build the project
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean install

# Use the Eclipse Temurin image to run the application
FROM eclipse-temurin:17-jdk
COPY --from=build /target/areaCalc-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
