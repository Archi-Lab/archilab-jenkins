#!/usr/bin/env bash

COMPOSE_PROJECT_NAME="archilab-jenkins"
docker build --pull -t $COMPOSE_PROJECT_NAME .

docker stack rm $COMPOSE_PROJECT_NAME

until [ -z "$(docker service ls --filter label=com.docker.stack.namespace=$COMPOSE_PROJECT_NAME -q)" ] || [ "$limit" -lt 0 ]; do
  sleep 1;
done

until [ -z "$(docker network ls --filter label=com.docker.stack.namespace=$COMPOSE_PROJECT_NAME -q)" ] || [ "$limit" -lt 0 ]; do
  sleep 1;
done

docker stack deploy -c docker-compose.yml $COMPOSE_PROJECT_NAME
