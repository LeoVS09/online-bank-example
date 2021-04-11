# Online Bank Example

Example of online banking service on different architectures for [Clean Archetecture presentation](https://slides.com/leovs09/deck/fullscreen)


## Current Architecture

Simplified onion architecture

Service implements hexagonal architecture. 
Current architecture showed with all pluses and minuses.

## Use Cases

Service implement use cases:
* Allow user send money to other user
* Allow admin transfer money between users

## Development

1) clone repository

2) Start database
```bash
# Will start database
make start
```

you then will be able to open [adminer page](http://localhost:8080/?pgsql=localhost%3A5432&username=postgres&db=bank&ns=public)
for explore database

3) Start boot application in your IDEA
