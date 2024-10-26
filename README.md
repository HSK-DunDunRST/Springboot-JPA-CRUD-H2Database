# Springboot JPA(H2-Database) CRUD Type Site Example

> **Brief Description**: This project is a Q&A site example developed using **Spring Boot**, **H2 Database**, **JPA**, and **Thymeleaf**. It demonstrates the fundamental features of a question-and-answer application.
>
> **Note**: This project serves as a practical demonstration of web development concepts using the Spring framework. [![WikiDocs](https://img.shields.io/badge/WikiDocs-Visit-blue?style=for-the-badge&logo=google-chrome&logoColor=white)](https://wikidocs.net/book/7601)

## Table of Contents
- [Project Overview](#project-overview)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Installation and Execution](#installation-and-execution)
- [Application Settings](#application-settings)
- [Key Features](#key-features)

## Project Overview

This project is built with **Spring Boot** as the primary framework, using **H2 Database** for data storage and managed via **JPA** for object-relational mapping. **Thymeleaf** serves as the server-side template engine, dynamically generating HTML pages that display questions and answers, making it easy for users to interact with the application.

## Technology Stack

- **Spring Boot**: A powerful framework for creating stand-alone, production-grade Spring applications.
- **H2 Database**: An embedded database that provides a fast, in-memory data store for development and testing.
- **JPA (Java Persistence API)**: A specification for managing relational data in Java applications, providing an abstraction layer for database interactions.
- **Thymeleaf**: A server-side Java template engine that processes and generates HTML, allowing for dynamic web page creation.
- **Java 17**: The programming language used to develop the application, providing modern features and enhancements.

## Project Structure

```plaintext
src
├── main
│   ├── java
│   │   └── com.mysite.sbb
│   │       ├── Answer                # Class handling answers
│   │       ├── Question              # Class handling questions
│   │       ├── User                  # Class managing user information
│   │       ├── CommonUtil.java       # Class providing common utility methods
│   │       └── DataNotFoundException.java # Exception class for handling cases when data is not found
│   │       └── MainController.java    # Main web controller responsible for handling requests
│   │       └── SbbApplication.java    # Entry point for the Spring Boot application
│   │       └── SecurityConfig.java     # Class managing security configurations
│   ├── resources
│   │   ├── templates                 # Thymeleaf template files for the web interface
│   │   ├── application.properties     # Configuration file for application settings
│   │   └── data.sql                  # Script for loading initial data into the database
└── test                              # Folder for unit and integration tests
```

## Installation and Execution

### 1. Prerequisites
- JDK 17 or higher
- Maven (or Gradle)
- An IDE (e.g., IntelliJ IDEA)

### 2. Clone the Project

```bash
git clone https://github.com/HSK-DunDunRST/Springboot-JPA-CRUD-H2Database.git
cd Springboot-JPA-CRUD-H2Database
```

### 3. Open in IntelliJ IDEA

1. Open IntelliJ IDEA and select `File -> Open...`, then choose the cloned project directory.
2. In IntelliJ IDEA, navigate to `File -> Settings -> Build, Execution, Deployment -> Build Tools -> Maven/Gradle`, and ensure that you have the JDK set to `Oracle OpenJDK 17`.
3. Click `Apply`, and the project will import based on the JDK version.
4. Ensure that Maven/Gradle is set up to automatically download dependencies.

### 4. Run the Application

1. Locate and run the `src/main/java/com/mysite/sbb/ProjectApplication.java` file.
2. By default, the application runs on `http://localhost:8080`.

### 5. Access the H2 Console

- After starting the application, you can access the H2 Console at `http://localhost:8080/h2-console`.
- Default connection information:
  - **Save Settings**: `Generic H2 (Embedded)`  
  - **Driver Class**: `org.h2.Driver`
  - **JDBC URL**: `jdbc:h2:~/local`
  - **Username**: `sa`
  - **Password**: (leave blank)

## Application Settings

- The configuration file is located at `src/main/resources/application.properties`.
  - **spring.application.name**: Defines the application name.
  - **server.port**: Sets the web server port number.
  - **spring.h2.console.enabled**: Enables access to the H2 database console.
  - **spring.h2.console.path**: Configures the access path for the H2 console.
  - **spring.datasource.url**: Specifies the URL for the H2 database.
  - **spring.datasource.driverClassName**: Indicates the database driver to use.
  - **spring.datasource.username**: Sets the username for database access.
  - **spring.datasource.password**: Sets the password for database access.
  - **spring.h2.console.settings.web-allow-others**: (Optional) Allows external access to the H2 Console.

## Key Features

- **User Management**: Allows users to create, read, update, and delete their profiles.
- **Question Management**: Users can create, view, edit, and delete questions.
- **Answer Management**: Users can provide answers to questions, with options to edit or delete.
- **Dynamic Web Pages**: Utilizes Thymeleaf for generating dynamic content based on user interactions.
- **H2 Database Management**: Easily manage the database and view data through the H2 console.

--- 

Feel free to customize any sections further as needed!
