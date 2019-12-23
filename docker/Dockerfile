# syntax=docker/dockerfile:experimental
FROM adoptopenjdk/openjdk11:alpine AS build
WORKDIR /workspace/app

COPY . /workspace/app
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean bootJar
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)

FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
ARG JAR_FILE=./build/libs/app.jar
COPY ${JAR_FILE} app.jar
RUN mkdir -p /var/warwick/ssl/
ADD docker/certificate.pem /var/warwick/ssl/cert.pem
ADD docker/privkey.pem /var/warwick/ssl/privkey.pem
ADD docker/chain.pem /var/warwick/ssl/chain.pem
COPY application-example-docker.yml application.yml
COPY external-conf/example-sso-config-example-docker.xml external-conf/example-sso-config.xml
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]