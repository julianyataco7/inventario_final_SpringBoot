FROM openjdk:17-jdk-slim  # Imagen base con Java 17
COPY target/Inventario_final-0.0.1-SNAPSHOT.jar app.jar  # Copia tu JAR
EXPOSE 8080  # Abre el puerto 8080
ENTRYPOINT ["java", "-jar", "app.jar"]  # Comando para ejecutar la app