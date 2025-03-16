# Traini8 Registry MVP

This is a Spring Boot application developed as a Minimum Viable Product (MVP) for Traini8, a startup focused on managing a registry of government-funded training centers. The project includes two APIs: one to create a training center and another to retrieve a list of training centers with filtering capabilities.

## Features
- **POST API**: Create and save a new training center with validation.
- **GET API**: Retrieve all training centers with optional filters (city, state, course, center name).
- **Database**: PostgreSQL with Spring Data JPA for persistence.
- **Validation**: Annotation-based validation with proper error messages.
- **Exception Handling**: Centralized exception handling using `@ControllerAdvice`.

## Prerequisites
- **Java**: 17 or higher
- **Maven**: 3.6 or higher
- **PostgreSQL**: 13 or higher
- **IDE**: IntelliJ IDEA
- **Postman**: For API testing

- # Training Centers API Documentation

## 1. POST /api/training-centers
**Description:** Creates a new training center and saves it to the database.

- **Method:** POST
- **Endpoint:** `http://localhost:8080/api/training-centers`

### Request Body:
```json
{
  "centerName": "SkillHub",
  "centerCode": "SKLHUB123456",
  "address": {
    "detailedAddress": "123 Main St",
    "city": "Delhi",
    "state": "Delhi",
    "pincode": "110001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Python"],
  "contactEmail": "contact@skillhub.com",
  "contactPhone": "9876543210"
}
```

### Response:
**Success (200 OK):** Returns the saved training center in JSON format with an auto-generated `createdOn` field.
```json
{
  "id": 1,
  "centerName": "SkillHub",
  "centerCode": "SKLHUB123456",
  "address": {
    "detailedAddress": "123 Main St",
    "city": "Delhi",
    "state": "Delhi",
    "pincode": "110001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Python"],
  "contactEmail": "contact@skillhub.com",
  "contactPhone": "9876543210",
  "createdOn": 1742234567
}
```

**Error (400 Bad Request):** Returns validation errors.
```json
{
  "centerName": "Center name is mandatory",
  "address.state": "State is mandatory"
}
```

---

## 2. GET /api/training-centers
**Description:** Retrieves a list of all training centers with optional filtering.

- **Method:** GET
- **Endpoint:** `http://localhost:8080/api/training-centers`

### Query Parameters (Optional):
- `city`: Filter by city (e.g., `Delhi`).
- `state`: Filter by state (e.g., `Delhi`).
- `course`: Filter by a course offered (e.g., `Java`).
- `centerName`: Filter by partial center name (e.g., `Skill`).

### Examples:
#### Get all centers:
```
GET http://localhost:8080/api/training-centers
```
**Response:**
```json
[
  {
    "id": 1,
    "centerName": "SkillHub",
    "centerCode": "SKLHUB123456",
    "address": {
      "detailedAddress": "123 Main St",
      "city": "Delhi",
      "state": "Delhi",
      "pincode": "110001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Python"],
    "contactEmail": "contact@skillhub.com",
    "contactPhone": "9876543210",
    "createdOn": 1742234567
  }
]
```

#### Filter by City:
```
GET http://localhost:8080/api/training-centers?city=Delhi
```

#### Filter by Course:
```
GET http://localhost:8080/api/training-centers?course=Java
```

#### Filter by Center Name:
```
GET http://localhost:8080/api/training-centers?centerName=Skill
```

#### Filter by City and State:
```
GET http://localhost:8080/api/training-centers?city=Delhi&state=Delhi
```

---

## 3. Configure Application Properties
Open `src/main/resources/application.properties` and update the following:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/training_registry
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8080
```
**Note:** Replace `yourpassword` with your actual PostgreSQL password.


## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/cseazeem/Backend_Traini8_Azeem.git
cd traini8-registry
