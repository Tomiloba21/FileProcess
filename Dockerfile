FROM openjdk:21-jdk-slim
VOLUME /tmp
WORKDIR /src
COPY target/fileUpload-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
EXPOSE 8080

