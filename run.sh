#!/usr/bin/env bash

project_name="archilab-jenkins"

docker build --pull -t $project_name .

docker stack rm $project_name

limit=15
until [ -z "$(docker service ls --filter label=com.docker.stack.namespace=$project_name -q)" ] || [ "$limit" -lt 0 ]; do
  sleep 1
  limit="$((limit - 1))"
done

limit=15
until [ -z "$(docker network ls --filter label=com.docker.stack.namespace=$project_name -q)" ] || [ "$limit" -lt 0 ]; do
  sleep 1
  limit="$((limit - 1))"
done

docker stack deploy -c docker-compose.yml $project_name
