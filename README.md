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

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/cseazeem/Backend_Traini8_Azeem.git
cd traini8-registry
