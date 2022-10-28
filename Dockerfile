FROM openjdk:17-alpine

EXPOSE 8080
VOLUME ["/opt/malsin"]

RUN addgroup -S spring && adduser -S spring -G spring

USER spring
COPY malsin-boot/target/malsin-boot*.jar /opt/malsin/app.jar

CMD ["java", "-jar", "/opt/malsin/app.jar"]

