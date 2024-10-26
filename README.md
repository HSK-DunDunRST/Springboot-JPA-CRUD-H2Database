아래는 "GitHub Repository" 뱃지를 "WikiDocs" 뱃지로 변경한 예제입니다. 

---

## Web Server and Web Page using Spring Boot + JPA + Thymeleaf

> **Brief Description**: This project is a simple web application developed using Spring Boot, H2 Database, JPA, and Thymeleaf.
> 
> **Note**: This is a study-based project created with reference to the Jump to Spring book on WikiDocs. [![WikiDocs](https://img.shields.io/badge/WikiDocs-Visit-blue?style=for-the-badge&logo=google-chrome&logoColor=white)](https://wikidocs.net/book/7601)

## Table of Contents
- [Project Overview](#project-overview)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Installation and Execution](#installation-and-execution)
- [Application Settings](#application-settings)
- [Key Features](#key-features)

## Project Overview

This project is developed based on **Spring Boot** with data stored in **H2 Database** and managed using **JPA**. **Thymeleaf** acts as the server-side template engine, linking with HTML files to create dynamic web pages.

## Technology Stack

- **Spring Boot**: A Java web framework that helps build web applications quickly and easily.
- **H2 Database**: An embedded relational database.
- **JPA (Java Persistence API)**: A standardized interface for managing data persistence between Java applications and relational databases.
- **Thymeleaf**: A template engine that generates dynamic HTML pages, displaying server-side data in web pages.
- **IntelliJ IDEA**: The integrated development environment (IDE) used for this project.

## Project Structure

```plaintext
src
├── main
│   ├── java
│   │   └── com.mysite.sbb
│   │       ├── controller      # Web controllers
│   │       ├── entity          # JPA entity classes
│   │       ├── repository      # JPA repository interfaces
│   │       ├── service         # Service classes
│   │       └── ProjectApplication.java  # Main application class
│   ├── resources
│   │   ├── templates           # Thymeleaf template files
│   │   ├── application.properties # Application settings
│   │   └── data.sql            # Initial data load script
└── test                        # Test code
```

## Installation and Execution

### 1. Prerequisites
- JDK 17 or higher
- Gradle
- IntelliJ IDEA

### 2. Clone the Project

```bash
git clone https://github.com/yourusername/yourproject.git
cd yourproject
```

### 3. Open in IntelliJ IDEA

1. Open IntelliJ IDEA, select `File -> Open...`, and choose the cloned project directory.
2. In the top left of IntelliJ IDEA, go to `File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle`, and select `Oracle OpenJDK 17` as the `Gradle JVM`.
3. Then, under `Settings -> Build, Execution, Deployment -> Compiler -> Java Compiler`, set the `Project bytecode version` to 17.
4. Click Apply, and Gradle will import based on the JDK version.
5. Set up Maven or Gradle to automatically download dependencies.

### 4. Run the Application

1. Locate and run the `src/main/java/com/mysite/sbb/SbbApplication.java` file.
2. By default, the application runs on `http://localhost:5000`.

### 5. Access the H2 Console

- After starting the application, the H2 Console is accessible at `http://localhost:8080/h2-console`.
- Default connection information:
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: (leave blank)

## Application Settings

- The configuration file is located at `src/main/resources/application.properties`.
  - **spring.application.name**: Sets the application name.
  - **server.port**: Specifies the web access port number.
  - **spring.h2.console.enabled**: Enables the H2 database console.
  - **spring.h2.console.path**: Sets the H2 database access URL.
  - **spring.datasource.url**: H2 database URL.
  - **spring.datasource.driverClassName**: Specifies the database driver.
  - **spring.datasource.username**: Database access username.
  - **spring.datasource.password**: Database access password.
  - **spring.h2.console.settings.web-allow-others**: (Optional) Allows external access to the H2 Console.

## Key Features

- **User Management**: Create, read, update, and delete users.
- **Post Management**: Create, read, update, and delete posts.
- **Additional Post Features**: Markdown support, polls, and replies.
- **H2 Database Management**: Manage the database through the H2 Console.
