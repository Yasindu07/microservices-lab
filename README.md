# Microservices Lab

A Spring Boot microservices project demonstrating service communication through an API Gateway.

## Tech Stack

- Java 17
- Spring Boot 4.0.3
- Spring Cloud Gateway
- Docker & Docker Compose
- Maven

## Services

| Service         | Port | Description                         |
| --------------- | ---- | ----------------------------------- |
| API Gateway     | 8080 | Routes requests to backend services |
| Item Service    | 8081 | Manages product items               |
| Order Service   | 8082 | Manages orders with status tracking |
| Payment Service | 8083 | Processes payments                  |

## Project Structure

```
microservices-lab/
├── docker-compose.yml
├── api-gateway/
├── item-service/
├── order-service/
└── payment-service/
```

## API Endpoints

**Items** — via `/items`

- `GET /items` — List all items
- `POST /items` — Add a new item
- `GET /items/{id}` — Get item by ID

**Orders** — via `/orders`

- `GET /orders` — List all orders
- `POST /orders` — Place a new order
- `GET /orders/{id}` — Get order by ID

**Payments** — via `/payments`

- `GET /payments` — List all payments
- `POST /payments/process` — Process a payment
- `GET /payments/{id}` — Get payment by ID

## Getting Started

### Run with Docker Compose

```bash
docker-compose up --build
```

All services will start and communicate over an internal Docker network. The API Gateway is accessible at `http://localhost:8080`.

### Run Individually

Each service can be run standalone with Maven:

```bash
cd <service-directory>
./mvnw spring-boot:run
```
