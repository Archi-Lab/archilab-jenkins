#!/usr/bin/env bash

docker build --pull -t archilab-jenkins .

docker stack rm archilab-jenkins

docker stack deploy -c docker-compose.yml archilab-jenkins
