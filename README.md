# Enviro365 Waste Sorting Application

## Overview

The **Enviro365 Waste Sorting Application** is an innovative solution aimed at promoting sustainable waste management practices. As part of my graduate internship at **Enviro365**, I developed a set of RESTful APIs to support the waste sorting mobile application. This application empowers users to make environmentally conscious decisions by providing them with relevant waste category information, disposal guidelines, and recycling tips.

The backend of this application is built using **Spring Boot**, and it is designed to interact with a real-time mobile frontend. The backend is supported by an in-memory **H2 database** for rapid development and testing, while **Docker** is used to containerize the application for ease of deployment.

## Key Features

- **Waste Category Management**: Manage waste categories such as "Plastic", "Metal", "Glass", etc.
- **Disposal Guidelines**: Retrieve guidelines on how to dispose of different waste categories.
- **Recycling Tips**: Provide tips on how to recycle materials properly.
- **Input Validation**: Ensure that all incoming data meets the necessary requirements.
- **Dockerized**: The application is containerized for easy deployment.
- **In-Memory Database (H2)**: An H2 database is used for development, ensuring quick and simple setup.

## Technologies Used

- **Java 17**: For the backend development.
- **Spring Boot**: For creating RESTful APIs.
- **H2 Database**: In-memory database for quick development and testing.
- **Docker**: For containerizing the application and ensuring seamless deployment.
- **JUnit 5** and **Mockito**: For unit and integration testing.
- **Maven**: For managing project dependencies and builds.

## Setup Instructions

To run the application locally or in a Docker container, follow the steps below.

### Prerequisites

- **Java 21** or higher installed.
- **Maven** installed.
- **Docker** installed (optional for containerization).

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/enviro365-waste-sorting.git
cd enviro365-waste-sorting
