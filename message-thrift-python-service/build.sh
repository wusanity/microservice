#!/usr/bin/env bash
docker build -t 192.168.147.139:8081/micro-service/message-service:latest .

docker push 192.168.147.139:8081/micro-service/message-service:latest