FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/E-commerce-0.0.1-SNAPSHOT.jar E-commerce-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "-Dspring.datasource.url=jdbc:postgresql://postgres:5432/spring","/E-commerce-0.0.1-SNAPSHOT.jar"]