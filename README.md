# Online Bank Example

Example of online banking service on different architectures

## Current Architecture

Three layer / three tier architecture

Service implement three layer architecture for show all pluses and minuses of this architecture

## Use Cases

Service implement use cases:
* Allow user send money to other user
* Allow admin transfer money between users

## Changelog

* User with balance were split to account and user, for allow multiple users have one corporate account 

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