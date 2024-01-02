FROM jdk17

WORKDIR /app

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true

ENV PORT=8080 
ENV SPRING_REDIS_HOST=viaduct.proxy.rlwy.net SPRING_REDIS_PORT=52456
ENV SPRING_REDIS_USERNAME=NOT_SET SPRING_REDIS_PASSWORD=NOT_SET

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar app/target/petmanager-0.0.1-SNAPSHOT.jar