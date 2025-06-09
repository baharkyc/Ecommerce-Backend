# Ecommerce Backend

This is a backend project for a complete **online shopping application** developed using **Spring Boot**. The system is designed to manage essential features of an e-commerce platform, including user authentication, product browsing, filtering, ordering, and payment processing. The database is populated with real product data based on a dataset inspired by **Amazon product listings**.

##  Technologies Used

* **Java 17** – Main programming language
* **Spring Boot** – Application framework for creating stand-alone, production-grade Spring applications
* **Spring Security** – For authentication and authorization using JWT
* **Spring Data JPA** – For data persistence and repository abstraction
* **Hibernate** – ORM tool for database interaction
* **PostgreSQL** – Relational database used for storing application data
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

* **Product Filtering**
  Filter products by category, price range, and other attributes.

* **Order Management**
  Full order lifecycle including cart handling, order creation, and status tracking.

* **Payment Integration**
  Basic structure for processing payments during checkout (integration-ready).

* **DTO Usage**
  Manual mapping between entities and DTOs to maintain clean API and service layers.

* **Exception Handling**
  Centralized error responses with proper HTTP status codes and messages.

