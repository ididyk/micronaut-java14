FROM openjdk:14
WORKDIR /app
COPY ./ ./
RUN ./gradlew shadowJar

EXPOSE 8080
CMD java --enable-preview -Xmx128m  -jar build/libs/app-0.1-all.jar
