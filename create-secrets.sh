#!/usr/bin/env bash

docker secret create GITHUB_TOKEN ./secrets/GITHUB_TOKEN
docker secret create GITHUB_USERNAME ./secrets/GITHUB_USERNAME
docker secret create GITHUB_PASSWORD ./secrets/GITHUB_PASSWORD
docker secret create NEXUS_USERNAME ./secrets/NEXUS_USERNAME
docker secret create NEXUS_PASSWORD ./secrets/NEXUS_PASSWORD
docker secret create PROX_PROD_CERTS_SECRET ./secrets/PROX_PROD_CERTS_SECRET
docker secret create PROX_PROD_CERTS_CLIENT ./secrets/PROX_PROD_CERTS_CLIENT
docker secret create PROX_PROD_CERTS_CA_SERVER ./secrets/PROX_PROD_CERTS_CA_SERVER
docker secret create PROX_DEV_CERTS_SECRET ./secrets/PROX_DEV_CERTS_SECRET
docker secret create PROX_DEV_CERTS_CLIENT ./secrets/PROX_DEV_CERTS_CLIENT
docker secret create PROX_DEV_CERTS_CA_SERVER ./secrets/PROX_DEV_CERTS_CA_SERVER
docker secret create PROX_GP_WS2019_CERTS_SECRET ./secrets/PROX_GP_WS2019_CERTS_SECRET
docker secret create PROX_GP_WS2019_CERTS_CLIENT ./secrets/PROX_GP_WS2019_CERTS_CLIENT
docker secret create PROX_GP_WS2019_CERTS_CA_SERVER ./secrets/PROX_GP_WS2019_CERTS_CA_SERVER
docker secret create COALBASE_PROD_CERTS_SECRET ./secrets/COALBASE_PROD_CERTS_SECRET
docker secret create COALBASE_PROD_CERTS_CLIENT ./secrets/COALBASE_PROD_CERTS_CLIENT
docker secret create COALBASE_PROD_CERTS_CA_SERVER ./secrets/COALBASE_PROD_CERTS_CA_SERVER
docker secret create COALBASE_DEV_CERTS_SECRET ./secrets/COALBASE_DEV_CERTS_SECRET
docker secret create COALBASE_DEV_CERTS_CLIENT ./secrets/COALBASE_DEV_CERTS_CLIENT
docker secret create COALBASE_DEV_CERTS_CA_SERVER ./secrets/COALBASE_DEV_CERTS_CA_SERVER
