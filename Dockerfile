FROM openjdk:17-bullseye

WORKDIR /app

ENV DATASOURCE_URL postgresql://db:5432
ENV DATASOURCE_USERNAME postgres
ENV DATASOURCE_PASSWORD root
ENV DISCOVERY_SERVER_URL ds:8761

COPY mvnw .
COPY  pom.xml pom.xml
COPY ./* .
COPY  src/ src/
COPY .mvn/ .mvn/

EXPOSE 8081

ENTRYPOINT ["./mvnw","spring-boot:run"]
