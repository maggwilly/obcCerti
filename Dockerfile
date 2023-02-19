FROM openjdk:11
COPY /target/obcCerti-0.0.1-SNAPSHOT.jar  /usr/src/app/app.jar
WORKDIR /usr/src/app
EXPOSE 8080
CMD ["java", "-jar" , "app.jar"]