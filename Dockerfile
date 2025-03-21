FROM eclipse-temurin:21-jre

ENV TZ=America/Bogota
RUN apt-get update && apt-get install -y tzdata && rm -rf /var/lib/apt/lists/*
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /mazorcaUsers

COPY target/mazorcausers-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
