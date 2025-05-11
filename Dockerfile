# Etapa 1: Compilación (opcional si Cloud Build ya lo hace, pero bueno para compilaciones locales)
# Usaremos una imagen de Gradle con JDK 21 para compilar la aplicación.
# Puedes omitir esta etapa si Cloud Build maneja la compilación y solo quieres copiar el JAR.
# FROM gradle:8.7-jdk21 AS builder
# WORKDIR /home/gradle/project
# COPY --chown=gradle:gradle . .
# RUN gradle build --no-daemon

# Etapa 2: Creación de la imagen final de la aplicación
# Usamos una imagen JRE delgada para Java 21, ya que es más pequeña.
# eclipse-temurin es una opción popular y bien mantenida.
FROM eclipse-temurin:21-jre-jammy

# Argumento para el nombre del JAR. Cloud Build puede pasar este valor.
ARG JAR_FILE_NAME=estadsticaCliente-0.0.1-SNAPSHOT.jar

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado por Gradle desde el directorio de compilación de Cloud Build
# Cloud Build copia tu repositorio a /workspace.
# El JAR de Gradle usualmente está en build/libs/
# Asegúrate de que el nombre del JAR coincida con el que genera tu build.
# Si usaste la etapa de compilación 'builder' arriba, sería:
# COPY --from=builder /home/gradle/project/build/libs/${JAR_FILE_NAME} app.jar
# Si Cloud Build compila fuera de este Dockerfile (recomendado para cloudbuild.yaml):
COPY build/libs/${JAR_FILE_NAME} app.jar

# Puerto que expone tu aplicación (ajústalo si es diferente)
EXPOSE 8080

# Comando para ejecutar la aplicación Java
# El -Djava.security.egd=file:/dev/./urandom es para mejorar la velocidad de arranque en algunos entornos.
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

# Ejemplo de cómo pasar argumentos a tu aplicación Java (si los necesita):
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar", "--server.port=8080"]