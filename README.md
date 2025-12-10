# mydamnspringboot
A Spring Boot application with Hibernate JPA entities, demonstrating CRUD operations with REST APIs.

## Features

- Spring Boot 3.2.0 with Java 17
- Hibernate ORM for database persistence
- H2 in-memory database for development
- RESTful API endpoints for User and Product entities
- JPA repositories with custom query methods
- Comprehensive unit and integration tests

## Project Structure

```
src/
├── main/
│   ├── java/com/mydamnspringboot/
│   │   ├── MyDamnSpringBootApplication.java   # Main application class
│   │   ├── entity/
│   │   │   ├── User.java                      # User entity
│   │   │   └── Product.java                   # Product entity
│   │   ├── repository/
│   │   │   ├── UserRepository.java            # User JPA repository
│   │   │   └── ProductRepository.java         # Product JPA repository
│   │   └── controller/
│   │       ├── UserController.java            # User REST controller
│   │       └── ProductController.java         # Product REST controller
│   └── resources/
│       └── application.properties             # Application configuration
└── test/
    └── java/com/mydamnspringboot/             # Test classes
```

## Entities

### User Entity
- `id` (Long) - Primary key, auto-generated
- `name` (String) - User's name
- `email` (String) - User's email (unique)
- `createdAt` (LocalDateTime) - Timestamp of creation

### Product Entity
- `id` (Long) - Primary key, auto-generated
- `name` (String) - Product name
- `description` (String) - Product description
- `price` (BigDecimal) - Product price
- `quantity` (Integer) - Available quantity
- `createdAt` (LocalDateTime) - Timestamp of creation
- `updatedAt` (LocalDateTime) - Timestamp of last update

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Build the Project
```bash
mvn clean install
```

### Run the Application
```bash
mvn spring-boot:run
```

Or run the packaged JAR:
```bash
java -jar target/mydamnspringboot-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

### Run Tests
```bash
mvn test
```

## API Endpoints

### User Endpoints

- **GET** `/api/users` - Get all users
- **GET** `/api/users/{id}` - Get user by ID
- **POST** `/api/users` - Create a new user
  ```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
  ```
- **PUT** `/api/users/{id}` - Update user
- **DELETE** `/api/users/{id}` - Delete user

### Product Endpoints

- **GET** `/api/products` - Get all products
- **GET** `/api/products/{id}` - Get product by ID
- **GET** `/api/products/search?name={name}` - Search products by name
- **POST** `/api/products` - Create a new product
  ```json
  {
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99,
    "quantity": 10
  }
  ```
- **PUT** `/api/products/{id}` - Update product
- **DELETE** `/api/products/{id}` - Delete product

## Example Usage

### Create a User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john.doe@example.com"}'
```

### Get All Users
```bash
curl http://localhost:8080/api/users
```

### Create a Product
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","description":"High-performance laptop","price":999.99,"quantity":10}'
```

### Search Products
```bash
curl http://localhost:8080/api/products/search?name=laptop
```

## H2 Console

The H2 database console is available at: `http://localhost:8080/h2-console`

Connection details:
- JDBC URL: `jdbc:h2:mem:mydamndb`
- Username: `sa`
- Password: (leave empty)

## Technologies Used

- Spring Boot 3.2.0
- Spring Data JPA
- Hibernate ORM
- H2 Database
- Maven
- JUnit 5
