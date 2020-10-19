FROM 192.168.147.139:8081/micro-service/openjdk:8-jre
MAINTAINER wzp wuzph@digitalchina.com

COPY target/course-dubbo-service-1.0-SNAPSHOT.jar /course-service.jar

ENTRYPOINT ["java", "-jar", "/course-service.jar"]