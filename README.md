# Ecommerce Backend

This is a backend project for an e-commerce application developed using **Spring Boot**. The system is designed to manage core functionalities of an online store including user authentication, product management, category hierarchy, and order handling.

##  Technologies Used

* **Java 17** – Main programming language
* **Spring Boot** – Application framework for creating stand-alone, production-grade Spring applications
* **Spring Security** – For authentication and authorization using JWT
* **Spring Data JPA** – For data persistence and repository abstraction
* **Hibernate** – ORM tool for database interaction
* **MySQL** – Relational database for storing application data
* **Lombok** – To reduce boilerplate code
* **Validation API** – For input validation
* **Maven** – For dependency management and build automation

## 📦 Features

* **JWT-Based Authentication & Authorization**
  Secure login and registration system using JSON Web Tokens.

* **Role-Based Access Control**
  Different user roles with customizable authorities (e.g., admin, customer).

* **Category Management**
  Supports hierarchical category structures for organizing products.

* **Product Management**
  CRUD operations for products including price, description, stock, and images.

* **Order Management**
  Basic structure for handling order creation and status tracking.

* **DTO Usage**
  Clean separation between entity and API layers using DTOs.

* **Exception Handling**
  Centralized error responses with proper HTTP status codes and messages.

