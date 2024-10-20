FROM --platform=$BUILDPLATFORM docker.io/maven:3.9.9-eclipse-temurin-21-alpine AS build

COPY . /build
WORKDIR /build
RUN apk add --update npm curl git && \
    curl -L https://unpkg.com/@pnpm/self-installer | node && \
    cd webui && \
    pnpm i && \
    npm run build && \
    cd .. && \
    mv webui/dist src/main/resources/static && \
    mvn -B clean package --file pom.xml -T 1.5C -P thin-sqlite-packaging

FROM docker.io/eclipse-temurin:23-jre-alpine
LABEL maintainer="https://github.com/PBH-BTN/PeerBanHelper"
USER 0
ENV TZ=UTC
ENV JAVA_OPTS="-Xmx512M -Xss512k -XX:+UseG1GC -XX:+UseStringDeduplication -XX:+ShrinkHeapInSteps"
WORKDIR /app
VOLUME /tmp
COPY --from=build build/target/libraries /app/libraries
ENV PATH="${JAVA_HOME}/bin:${PATH}"
ENTRYPOINT ${JAVA_HOME}/bin/java ${JAVA_OPTS} -cp /app/libraries/* com.ghostchu.peerbanhelper.MainJumpLoader