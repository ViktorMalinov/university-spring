FROM openjdk:16
COPY build/libs/university-spring-0.0.1-SNAPSHOT.jar university-spring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/university-spring-0.0.1-SNAPSHOT.jar"]