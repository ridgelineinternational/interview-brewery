FROM openjdk:11
VOLUME /tmp
COPY build/libs/*.jar /app.jar
EXPOSE 8080
CMD java -Dserver.port=8081 -jar /app.jar