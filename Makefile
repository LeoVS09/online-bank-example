#!/usr/bin/env make

.PHONY: start clear

start:
	docker-compose up --force-recreate

clear:
	docker-compose down