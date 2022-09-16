.PHONY: help build test docker-build docker-test

default: help

help: ## Print this help
	@egrep -h '\s##\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-20s\033[0m %s\n", $$1, $$2}'

build: ## Compile the kata
	mvn clean compile

test: ## Run all the tests
	mvn clean test

docker-build: ## Build the Docker image
	docker build . -t gilded-rose-approval-testing

docker-test: ## Run all the tests using Docker
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project gilded-rose-approval-testing make test
