FROM openjdk

WORKDIR /app
## Lembrando que esse "apiPoliciaCivil-0.0.1-SNAPSHOT.jar" é o arquivo que fica dentro da pasta target .jar
COPY target/apiPoliciaCivil-0.0.1-SNAPSHOT.jar /app/apiPoliciaCivil.jar

ENTRYPOINT ["java", "-jar", "apiPoliciaCivil.jar"]