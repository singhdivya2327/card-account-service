# card-account-service
# Card Account API

A small Spring Boot REST service that I'm building step by step to refresh my
Java backend skills after a career break. It's a work in progress, and I add a
layer at a time as I finish each topic.

## Tech stack
- Java 21
- Spring Boot 4.1.2 (Spring Web MVC, Validation)
- Gradle

## Run locally
Requires JDK 21.

    ./gradlew bootRun

The app starts on http://localhost:8080.

## Endpoints
| Method | Path    | Description                 |
|--------|---------|-----------------------------|
| GET    | /health | Returns a simple status text |

## Status
Done:
- Project setup, package structure, health endpoint

Planned (in this order):
- Card account model, service layer, and GET /accounts endpoints (in-memory data) -- DONE
| GET    | /accounts      | Returns all card accounts (in-memory data)      |
| GET    | /accounts/{id} | Returns one account, or 404 if it doesn't exist |
- Request validation and global exception handling


## Running locally

The API is secured with OAuth2 (JWT bearer tokens), so a secret is required at startup.

Set `JWT_SECRET` (at least 32 characters) before running:

```powershell
$env:JWT_SECRET="your-secret-at-least-32-characters-long"
.\gradlew.bat bootRun
```

Scopes: `accounts.read` for GET, `accounts.write` for POST. Requests without a valid token get 401. A valid token without the required scope gets 403.
- Spring Security with JWT login
- MySQL with Spring Data JPA, and transactions
- Unit tests, Docker, and splitting into microservices
