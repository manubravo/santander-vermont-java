# Users API REST

This is a Spring Boot application for Santander (Vermont), a sample API REST project.

## Project Structure

The project is structured as follows:

- `src/main/java/com/santander/vermont`: Contains the main Java source code for the application.
- `src/main/resources`: Contains application properties and configuration files.
- `src/test`: Contains test classes.
- `pom.xml`: Maven Project Object Model file specifying project dependencies and configuration.

## Requirements

- Java 17 or higher.
- Maven for building and managing project dependencies.

## Dependencies

This project uses the following dependencies:

- **Spring Boot**: Provides the basic framework for building the application.
- **Spring Boot Data JPA**: Offers support for Spring Data JPA.
- **Spring Boot Web**: Provides web support.
- **Spring Boot DevTools**: Includes development tools for a smoother development experience.
- **H2 Database**: An in-memory database for development and testing.
- **MariaDB Java Client**: Provides support for the MariaDB database.
- **Lombok**: Reduces boilerplate code by automatically generating getter and setter methods.
- **Spring Boot Starter Test**: Includes dependencies for testing.
- **Swagger**: Includes dependencies for testing.

## Building and Running the Project

To build and run the project, follow these steps:

1. Ensure you have Java 17 and Maven installed on your system.

2. Open a command prompt or terminal.

3. Navigate to the root directory of your project where the `pom.xml` file is located.

4. Run the following Maven command to build and start the Spring Boot application:

   ```bash
   mvn clean package
   ```

   ```bash
   mvn spring-boot:run
   ```

## URL

   ```bash
   http://localhost:8080/api/users
   ```

   ```bash
   http://localhost:8080/api/copy
   ```

   ```bash
   http://localhost:8080/api/docs/swagger-ui/index.html
   ```

## Additional Documentation

- [GO TO Challenge](/docs/CHALLENGE.md)