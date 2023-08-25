# Leave App Server - Spring Boot Application

Welcome to the Leave App Server repository! This Spring Boot application provides the backend API for managing employee leave requests.

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Technologies Used](#technologies-used)

## Introduction

The Leave App Server is the backend application that handles employee leave requests and provides data to the frontend client. It utilizes Spring Boot to create RESTful APIs for submitting and fetching leave details.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 8 or later
- Maven (https://maven.apache.org/)

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/AbhishekMali21/LEAVE-APP-SERVER.git
   cd leave-app-server
   ```

2. **Build the Project:**

   ```bash
   mvn clean install
   ```

3. **Run the Application:**

   ```bash
   java -jar target/leave-app-server.jar
   ```

The application will start and run on the default port 9090.

## Usage

1. **Access the API:**

   You can access the API using the base URL `http://localhost:9090/api`.
   You can access the API documentation using the Swagger URL `http://localhost:9090/swagger-ui/index.html#/`.

3. **Submit Leave Requests:**

   Use the appropriate API endpoint to submit leave requests. The API is designed to handle different types of leave-related operations.

4. **Fetch Leave Records:**

   Use the API endpoints to fetch leave records for specific employees or all employees.

## API Endpoints

- `/api/leaves/save`: Submit a new leave request.
- `/api/leaves/employee/{empId}`: Fetch leave records for a specific employee.
- `/api/leaves/all`: Fetch leave records for all employees.

Refer to the code and Swagger API documentation for more details on request and response structures.

## Technologies Used

- Java with Spring Boot (https://spring.io/projects/spring-boot)
- Spring Data JPA for database interaction
- Maven for build and dependency management
