# eaa-test-server-kgreen

### Description

Server-side application handles requests and responses through J2EE Spring Boot components implementing CRUD server interfaces for a Person model. The Person model contains an auto-generated ID (UUID), first name, last name, and email address.

    ```
	[{"id":"e2201e76-a13b-459b-9602-9bc29a264702","givenname":"Charlie","surname":"Brown","email":"charlie.brown@peanuts.org"},
	{"id":"12af1b4d-d45e-4154-b071-b8e5738a8147","givenname":"Sally","surname":"Brown","email":"sally.brown@peanuts.org"},
	{"id":"20b9a63f-6499-45f2-b40f-b80398fb7403","givenname":"Peppermint","surname":"Patty","email":"peppermint.patty@peanuts.org"},
	{"id":"b870eb62-6eef-4a70-b733-42ae904d7b50","givenname":"Pig","surname":"Pen","email":"pig.pen@peanuts.org"},
	{"id":"b3bbe22b-ebbf-4ecd-b1bf-2eb660ff856c","givenname":"Linus","surname":"VanPelt","email":"linus.vanpelt@peanuts.org"},
	{"id":"dd5d694e-8897-406c-aa77-faf1eef2f407","givenname":"Linux","surname":"VanPelt","email":"linux.vanpelt@peanuts.org"},
	{"id":"a8e9e15b-f1ac-4a63-b187-a538dfd5bce4","givenname":"Lucy","surname":"VanPelt","email":"lucy.vanpelt@peanuts.org"},
	{"id":"9bd82fbf-b727-4f3b-b3be-b4d5949f1826","givenname":"Franklin","surname":"X","email":"franklin.x@peanuts.org"},
	{"id":"59664a26-d497-4615-9337-816d4838674c","givenname":"Marcy","surname":"X","email":"marcy.x@peanuts.org"}]
    ```

## Development server

Run As Spring Boot App.

    Http Verb | Endpoint | Payload Data (JSON) | Result
    --- | --- | --- | --- |
    POST | http://localhost:8080/v1/person/ | {"id":null,"givenname":"Charlie","surname":"Brown","email":"charlie.brown@peanuts.org"} |  Create One
    GET | http://localhost:8080/v1/person/ | none | Read All
    GET | http://localhost:8080/v1/person/{id} | none | Read One
    PUT	 | http://localhost:8080/v1/person/{id} | {"id":"e2201e76-a13b-459b-9602-9bc29a264702","givenname":"Charlie","surname":"Brown","email":"charlie.brown@peanuts.org"} |  Update One
    DELETE | http://localhost:8080/v1/person/{id} | none | Delete One

## Development environment

This project created in [eclipse](https://www.eclipse.org/downloads/packages/release/neon/3/eclipse-ide-java-ee-developers) Version: Neon.3 Release (4.6.3) with the [Spring STS](https://marketplace.eclipse.org/content/spring-tools-aka-spring-ide-and-spring-tool-suite).

## To Do

Next steps for this application.

* Migrate Spring Boot application to Spring Cloud microservice.
* MySQL for persistent storage.
* Docker container for web readiness.
