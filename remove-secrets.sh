#!/usr/bin/env bash

docker secret rm GITHUB_TOKEN
docker secret rm GITHUB_USERNAME
docker secret rm GITHUB_PASSWORD
docker secret rm NEXUS_USERNAME
docker secret rm NEXUS_PASSWORD
docker secret rm PROX_PROD_CERTS_SECRET
docker secret rm PROX_PROD_CERTS_CLIENT
docker secret rm PROX_PROD_CERTS_CA_SERVER
docker secret rm PROX_DEV_CERTS_SECRET
docker secret rm PROX_DEV_CERTS_CLIENT
docker secret rm PROX_DEV_CERTS_CA_SERVER
docker secret rm PROX_GP_WS2019_CERTS_SECRET
docker secret rm PROX_GP_WS2019_CERTS_CLIENT
docker secret rm PROX_GP_WS2019_CERTS_CA_SERVER
docker secret rm COALBASE_PROD_CERTS_SECRET
docker secret rm COALBASE_PROD_CERTS_CLIENT
docker secret rm COALBASE_PROD_CERTS_CA_SERVER
docker secret rm COALBASE_DEV_CERTS_SECRET
docker secret rm COALBASE_DEV_CERTS_CLIENT
docker secret rm COALBASE_DEV_CERTS_CA_SERVER
docker secret rm SONARQUBE_TOKEN
