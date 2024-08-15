# Library Management System

## Overview

The Library Management System is a Spring Boot application designed to manage books, patrons, and borrowing records in a library. This application provides endpoints for adding, updating, deleting, and retrieving books and patrons, as well as managing the borrowing and returning of books.

## Project Structure
```
src/main/java/com/example/library/
├── controller # Contains REST controllers for handling API requests
│ ├── BookController.java
│ ├── PatronController.java
│ └── BorrowingController.java
├── dto # Contains Data Transfer Objects (DTOs)
│ ├── BookDTO.java
│ ├── PatronDTO.java
│ └── BorrowingRecordDTO.java
├── model # Contains JPA entity classes
│ ├── Book.java
│ ├── Patron.java
│ └── BorrowingRecord.java
├── repository # Contains Spring Data JPA repository interfaces
│ ├── BookRepository.java
│ ├── PatronRepository.java
│ └── BorrowingRecordRepository.java
├── service # Contains service classes for business logic
│ ├── BookService.java
│ ├── PatronService.java
│ └── BorrowingRecordService.java
├── LibraryApplication.java # Main application class
└── resources # Contains application configuration and resource files
└── application.properties
```

## Entities

### Book

Represents a book in the library.

- **id**: Unique identifier (Long)
- **title**: Title of the book (String)
- **author**: Author of the book (String)
- **publicationYear**: Year of publication (int)
- **isbn**: ISBN of the book (String)

### Patron

Represents a library patron.

- **id**: Unique identifier (Long)
- **name**: Name of the patron (String)
- **email**: Email of the patron (String)
- **phone**: Phone number of the patron (String)

### BorrowingRecord

Represents a record of a book being borrowed by a patron.

- **id**: Unique identifier (Long)
- **book**: Book being borrowed (Book)
- **patron**: Patron who borrowed the book (Patron)
- **borrowDate**: Date when the book was borrowed (LocalDate)
- **returnDate**: Date when the book was returned (LocalDate)

## Repositories

- **BookRepository**: Interface for CRUD operations on `Book` entities.
- **PatronRepository**: Interface for CRUD operations on `Patron` entities.
- **BorrowingRecordRepository**: Interface for CRUD operations on `BorrowingRecord` entities.

## Services

- **BookService**: Business logic for managing books.
- **PatronService**: Business logic for managing patrons.
- **BorrowingRecordService**: Business logic for managing borrowing and returning of books.

## Controllers

- **BookController**: REST API endpoints for managing books.
- **PatronController**: REST API endpoints for managing patrons.
- **BorrowingController**: REST API endpoints for managing borrowing and returning books.

## API Endpoints

### Books

- **GET /api/books**: Retrieve all books.
- **GET /api/books/{id}**: Retrieve a book by ID.
- **POST /api/books**: Add a new book.
- **PUT /api/books/{id}**: Update an existing book.
- **DELETE /api/books/{id}**: Delete a book.

### Patrons

- **GET /api/patrons**: Retrieve all patrons.
- **GET /api/patrons/{id}**: Retrieve a patron by ID.
- **POST /api/patrons**: Add a new patron.
- **PUT /api/patrons/{id}**: Update an existing patron.
- **DELETE /api/patrons/{id}**: Delete a patron.

### Borrowing Records

- **POST /api/borrow/{bookId}/patron/{patronId}**: Borrow a book.
- **PUT /api/return/{bookId}/patron/{patronId}**: Return a borrowed book.

## Setup and Running

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yousefdotpy/library-management-system.git
2. **Navigate to Project Directory**
   ```bash
   cd library-management-system
3. **Build the Project**
   ```bash
   ./mvnw clean install
5. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
6. **Access the API**
   The application will be running at http://localhost:8080. You can use tools like Postman or cURL to interact with the API endpoints.
   And for the API documentation you can access it through at http://localhost:8080/swagger-ui/index.html.
   


