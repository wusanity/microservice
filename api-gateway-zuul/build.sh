#!/usr/bin/env bash
mvn package

docker build -t 192.168.147.139:8081/micro-service/api-gateway-zuul:latest .

docker push 192.168.147.139:8081/micro-service/api-gateway-zuul:latest