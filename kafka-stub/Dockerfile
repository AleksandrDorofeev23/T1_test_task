FROM gradle:8.5-jdk17 AS builder

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle clean bootJar --no-daemon

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/kafka-stub-1.0-SNAPSHOT.jar app.jar

RUN mkdir -p /app/logs /opt/jmx_exporter

COPY jmx_prometheus_javaagent-1.0.1.jar /opt/jmx_exporter/
COPY jmx_config.yml /opt/jmx_exporter/

EXPOSE 8099 8098

ENTRYPOINT ["java", \
    "-javaagent:/opt/jmx_exporter/jmx_prometheus_javaagent-1.0.1.jar=8098:/opt/jmx_exporter/jmx_config.yml", \
    "-jar", "app.jar"]