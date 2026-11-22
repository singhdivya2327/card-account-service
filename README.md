# Card Account API

A small Spring Boot REST service that I'm building step by step to refresh my
Java backend skills after a career break. It's a work in progress, and I add a
layer at a time as I finish each topic.

## Tech stack
- Java 21
- Spring Boot 4.1.2 (Spring Web MVC, Validation)
- Spring Security (OAuth2 resource server, JWT)
- Gradle

## Run locally
Requires JDK 21.

The API is secured with OAuth2 (JWT bearer tokens), so a secret is required at startup.
Set `JWT_SECRET` (at least 32 characters) before running:

```powershell
$env:JWT_SECRET="your-secret-at-least-32-characters-long"
.\gradlew.bat bootRun
```

The app starts on http://localhost:8080.

## Endpoints
| Method | Path           | Required scope   | Description                                     |
|--------|----------------|------------------|-------------------------------------------------|
| GET    | /health        | any valid token  | Returns a simple status text                    |
| GET    | /accounts      | `accounts.read`  | Returns all card accounts (in-memory data)      |
| GET    | /accounts/{id} | `accounts.read`  | Returns one account, or 404 if it doesn't exist |
| POST   | /accounts      | `accounts.write` | Creates an account and returns 201              |

Requests without a valid token get 401. A valid token without the required scope gets 403.

## Status
Done:
- Project setup, package structure, health endpoint
- Card account model, service layer, and accounts endpoints (in-memory data)
- POST /accounts
- Security: JWT bearer token validation with scope-based access

Planned (in this order):
- Request validation and global exception handling
- MySQL with Spring Data JPA, and transactions
- Unit tests, Docker, and splitting into microservices
