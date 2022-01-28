FROM openjdk:11-jre
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/Exec1_Todo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} todo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/todo.jar"]

