#!/usr/bin/env bash
mvn package

docker build -t 192.168.147.139:8081/micro-service/course-edge-service:latest .

docker push 192.168.147.139:8081/micro-service/course-edge-service:latest