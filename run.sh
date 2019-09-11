#!/usr/bin/env bash

compose_project_name="archilab-jenkins"

docker build --pull -t $compose_project_name .

docker stack rm $compose_project_name

limit=15
until [ -z "$(docker service ls --filter label=com.docker.stack.namespace=$compose_project_name -q)" ] || [ "$limit" -lt 0 ]; do
  sleep 1;
  limit="$((limit-1))"
done

limit=15
until [ -z "$(docker network ls --filter label=com.docker.stack.namespace=$compose_project_name -q)" ] || [ "$limit" -lt 0 ]; do
  sleep 1;
  limit="$((limit-1))"
done

docker stack deploy -c docker-compose.yml $compose_project_name
