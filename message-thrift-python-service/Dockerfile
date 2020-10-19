FROM 192.168.147.139:8081/micro-service/python-base:latest
MAINTAINER wzp wuzph@digitalchina.com

ENV PYTHONPATH /
COPY message /message

ENTRYPOINT ["python", "/message/message_service.py"]