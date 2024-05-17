FROM openjdk:17-bullseye

WORKDIR /app

COPY mvnw .

COPY .mvn/ .mvn/

COPY pom.xml .

COPY src/ src/

EXPOSE 8081

ENTRYPOINT ["./mvnw","spring-boot:run"]

ENV DB_URL postgresql://db:5432
ENV DB_USERNAME postgres
ENV DB_PASSWORD root
ENV DISCOVERY_SERVER_URL ds:8761

