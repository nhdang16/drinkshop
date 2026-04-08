# Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Khớp với cổng Render mặc định
EXPOSE 10000

ENTRYPOINT ["java", "-Xmx300m", "-Xms256m", "-jar", "app.jar", "--server.port=10000"]
