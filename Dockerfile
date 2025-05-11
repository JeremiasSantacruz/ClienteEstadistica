# Etapa 1: Construcción
FROM gradle:8.14.0-jdk21 AS builder
WORKDIR /app

# Copiar solo los archivos de configuración de Gradle para aprovechar el caché de Docker
COPY gradle gradle
COPY gradlew .
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew

# Descarga las dependencias sin compilar la aplicación
RUN ./gradlew dependencies --no-daemon

# Copiar el resto del código fuente
COPY src src

# Compilar la aplicación
RUN ./gradlew build --no-daemon

# Etapa 2: Imagen final
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=builder /app/build/libs/*.jar app.jar

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]