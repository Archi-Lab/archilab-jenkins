#!/usr/bin/env bash

#docker run \
#  -u root \
#  --rm \
#  -d \
#  -p 8080:8080 \
#  -p 50000:50000 \
#  -v archilab-jenkins-data:/var/jenkins_home \
#  -v /var/run/docker.sock:/var/run/docker.sock \
#  --name archilab-jenkins \
#  jenkins/jenkins:lts-alpine

#docker exec -it archilab-jenkins apk add docker

docker build -t archilab-jenkins .

docker stack deploy -c docker-compose.yml archilab-jenkins
