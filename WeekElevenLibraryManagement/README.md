# Library Management System

This is a library management system built using Spring Boot. It provides a set of RESTful APIs for managing books, authors, categories, publishers, and book borrowings.

## Features

- CRUD operations for books, authors, categories, and publishers.
- Ability to borrow and return books.
- Integration with Spring Security for authentication and authorization.
- Secure endpoints for administrative tasks.

## API Endpoints

| Endpoint                        | Description                            |
|---------------------------------|----------------------------------------|
| `/api/books`                    | Manage books (GET, POST)               |
| `/api/books/{id}`               | Get, update, or delete a specific book |
| `/api/books/borrow`             | Borrow a book (POST)                   |
| `/api/authors`                  | Manage authors (GET, POST)             |
| `/api/authors/{id}`             | Get, update, or delete a specific author|
| `/api/categories`               | Manage categories (GET, POST)          |
| `/api/categories/{id}`          | Get, update, or delete a specific category|
| `/api/publishers`               | Manage publishers (GET, POST)          |
| `/api/publishers/{id}`          | Get, update, or delete a specific publisher|
| `/api/borrow`                   | Manage book borrowings (GET, POST)     |
| `/api/borrow/{id}`              | Get, update, or delete a specific borrowing|

## Installation

1. Clone the repository: 
2. Navigate to the project directory: `cd WeekElevenLibraryManagement`
3. Build the project: `mvn clean install`
4. Run the application: `java -jar target/WeekElevenLibraryManagement.jar`

## Configuration

- Database configuration: Update `application.properties` file with your database credentials.
