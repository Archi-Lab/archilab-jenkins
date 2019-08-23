#!/usr/bin/env bash

docker build -t archilab-jenkins .

docker stack deploy -c docker-compose.yml archilab-jenkins
