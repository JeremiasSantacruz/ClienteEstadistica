FROM eclipse-temurin:21-jdk-focal AS builder
WORKDIR /app

COPY gradlew .
COPY gradlew.bat .
COPY gradle ./gradle

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src ./src

# Descargar las dependencias de Gradle y los plugins
RUN gradle dependencies --write-locks

# Construir la aplicación
RUN gradle bootJar

# ---
# Fase para la imagen final de ejecución
# ---
FROM eclipse-temurin:21-jre-focal
WORKDIR /app

# Copiar solo el JAR construido de la fase anterior
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]