FROM 192.168.147.139:8081/micro-service/openjdk:8-jre
MAINTAINER wzp wuzph@digitalchina.com

COPY target/user-thrift-service-1.0-SNAPSHOT.jar /user-service.jar

ENTRYPOINT ["java", "-jar", "/user-service.jar"]