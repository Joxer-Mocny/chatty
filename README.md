# Chatty (Java Spring Boot Project)

Chatty is a lightweight chat backend written in Java using Spring Boot. It enables sending messages between users and retrieving received messages via REST API endpoints. The project is built with clean code practices and includes unit tests.

## 💡 Features

- Send messages between users
- Retrieve messages for a specific recipient
- List all unique recipients who have received messages
- REST API with JSON format
- Unit tests for service and controller layers

## 📬 API Endpoints

| Method | Endpoint                        | Description                        |
|--------|----------------------------------|------------------------------------|
| POST   | `/api/chat/message`             | Send a new message                 |
| GET    | `/api/chat/messages/{recipient}`| Get all messages for a recipient   |
| GET    | `/api/chat/users`               | Get all recipients (users)         |

### Sample Message JSON
```json
{
  "sender": "Alice",
  "recipient": "Bob",
  "content": "Hello Bob!"
}
```

## 🚀 How to Run

1. Clone the repository:
```bash
git clone https://github.com/Joxer-Mocny/chatty.git
cd chatty
```

2. Run the application:
```bash
mvn spring-boot:run
```

The backend will be available at `http://localhost:8080`

## 🧪 Running Tests

Unit tests cover both the service and controller layers.
Run all tests using Maven:
```bash
mvn test
```

## ✅ Requirements

- Java 21+
- Maven 3.6+

## 🛠️ Technologies

- Java 21
- Spring Boot 3.2.4
- JUnit 5
- Mockito (used in controller tests)



