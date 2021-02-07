
# worldbank-api

Projeto desenvolvido para consumir a API World Bank.

http://api.worldbank.org

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

- Java 11
- quarkus 1.11.1.Final
    - quarkus-resteasy
    - quarkus-rest-client
    - quarkus-resteasy-jsonb
    - quarkus-smallrye-health
    - quarkus-smallrye-openapi
    - quarkus-smallrye-metrics
    - quarkus-junit5-mockito
    - mockito-junit-jupiter
    - rest-assured
    - lombok

# Execução do projeto 

### Passo 1
```shell script
$ git clone https://github.com/Ramonrz/worldbank.git
```
### Passo 2 
```shell script
$ cd worldbank-api
```
### Passo 3
```shell script
$ mvn clean install
```
### Passo 4
```shell script
$ cd ..
```
### Passo 5

```shell script
$ docker-compose up -d
```
## Swagger
http://localhost:8080/q/swagger-ui

- worldbank-app não foi disponibilizado em container
