# University-Assignment---Software-Technology

A full-stack web application for managing university student traineeships, developed for the **Software Engineering (MYY803)** course at the Department of Computer Science & Engineering, University of Ioannina.

## Tech Stack
* **Backend:** Java 17, Spring Boot 3.4.3 (Spring Web, Spring Data JPA, Spring Security)
* **Frontend:** Thymeleaf, Bootstrap 4
* **Database:** MySQL (Hibernate ORM)
* **Build Tool:** Maven

## Features & User Roles
The application supports user registration, authentication (with BCrypt password encoding), and role-based access control across four roles:
* **Student:** Create and update a student profile (student ID, skills, interests, preferred location) and apply for a traineeship position.
* **Company:** Create a company profile, announce new traineeship positions, and view all posted positions.
* **Professor:** Create and update an academic profile and research interests.
* **Committee:** Manage the committee profile and review the list of students who have applied for a traineeship.

## Local Setup & Installation

1. **Database Setup:** Create an empty MySQL database named `myy803_demo` (tables are generated automatically via Hibernate `ddl-auto=update`).
2. **Configuration:** Update the database connection details (port, username, and password) in `src/main/resources/application.properties`.
3. **Run the Application:**
   ```bash
   mvn spring-boot:run -DskipTests
