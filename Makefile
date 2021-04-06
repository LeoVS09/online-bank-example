#!/usr/bin/env make

.PHONY: start

start:
	docker-compose up --force-recreate
