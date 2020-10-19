FROM 192.168.147.139:8081/micro-service/openjdk:8-jre
MAINTAINER wzp wuzph@digitalchina.com

COPY target/course-edge-service-1.0-SNAPSHOT.jar /course-edge-service.jar

ENTRYPOINT ["java", "-jar", "/course-edge-service.jar"]