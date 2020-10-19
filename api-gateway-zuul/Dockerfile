FROM 192.168.147.139:8081/micro-service/openjdk:8-jre
MAINTAINER wzp wuzph@digitalchina.com

COPY target/api-gateway-zuul-1.0-SNAPSHOT.jar /api-gateway-zuul.jar

ENTRYPOINT ["java", "-jar", "/api-gateway-zuul.jar"]