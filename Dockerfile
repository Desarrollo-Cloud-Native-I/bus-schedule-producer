FROM eclipse-temurin:22-jdk AS buildstage

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:22-jdk

WORKDIR /app

# Copiar el JAR compilado
COPY --from=buildstage /app/target/bus-schedule-producer-0.0.1-SNAPSHOT.jar /app/bus-schedule-producer.jar

# Exponer el puerto del producer
EXPOSE 8087

ENTRYPOINT [ "java", "-jar", "/app/bus-schedule-producer.jar" ]
