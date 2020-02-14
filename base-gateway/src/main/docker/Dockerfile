FROM openjdk:8-jdk-alpine
MAINTAINER Julius
VOLUME /tmp
ADD base-gateway-0.0.1.jar gateway.jar
ENV TZ=Asia/shanghai
ENV SIZE_OPT=128m
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -Xms64m -Xmx$SIZE_OPT -jar gateway.jar