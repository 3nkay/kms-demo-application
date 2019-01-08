FROM openjdk:11.0.1-jre-slim-stretch

MAINTAINER n.kavtur@gmail.com

WORKDIR /app

COPY target/*.jar .

COPY entrypoint.sh .

CMD ["/bin/sh","/app/entrypoint.sh"]
