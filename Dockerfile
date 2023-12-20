FROM openjdk:21
COPY ./target/*.jar /app/app.jar
WORKDIR /app
EXPOSE 8087
CMD ["java", "-jar", "app.jar"]