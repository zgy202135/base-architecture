FROM openjdk:8-jdk-alpine
# 作者
MAINTAINER Julius

# 声明一个挂载点 ，容器内此路径回对应宿主机的某个文件夹
VOLUME /tmp
ADD base-common-0.0.1.jar common.jar
ENV TZ=Asia/Shanghai
ENV SIZE_OPT=128m
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -Xms64m -Xmx$SIZE_OPT -jar common.jar
