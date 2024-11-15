FROM openjdk:21-jdk
LABEL authors="Kestrel"
COPY build/libs/hotel-back-0.0.1-SNAPSHOT.jar hotel-back-app.jar
ENTRYPOINT ["java", "-jar", "hotel-back-app.jar"]