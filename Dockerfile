FROM docker.neg/ecbd/openjdk:8u181-jdk-alpine3.8

ENV PROJECT_BASE_DIR /opt/app/shepher/

WORKDIR $PROJECT_BASE_DIR

COPY ./lib/*.jar $PROJECT_BASE_DIR
COPY ./bin/run.sh $PROJECT_BASE_DIR

RUN chmod +x *.sh
ENTRYPOINT ["bash","run.sh"]