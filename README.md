# Enviro365 Waste Sorting Application

## **Live Website**: [Enviro365](https://environment365.onrender.com)

## Overview
The **Enviro365 Waste Sorting Application** is a cutting-edge solution designed to promote sustainable waste management practices. The application provides users with intuitive tools for managing waste categories, understanding disposal guidelines, and accessing recycling tips. It is built with scalability and maintainability in mind, utilizing industry best practices in software development.

The backend leverages a **persistent H2 database** for rapid development and testing, with **Docker** ensuring seamless containerization for deployment across environments. The application is deployed on **Render**, a cloud platform, and is fully integrated with a **GitHub CI/CD pipeline** to automate builds, testing, and deployments.

## Key Features
- **Waste Category Management**: Manage various waste categories, including "Plastic", "Metal", "Glass", and more.
- **Disposal Guidelines**: Retrieve and display guidelines on how to properly dispose of each waste category.
- **Recycling Tips**: Offer helpful tips for recycling materials efficiently.
- **Input Validation**: Ensure that all incoming data meets the required standards for consistency and accuracy.
- **Dockerized**: The application is fully containerized, ensuring a smooth deployment process and environment consistency.
- **Persistent Database (H2)**: Uses a persistent H2 database, facilitating rapid development and quick testing cycles.

## Technologies Used
- **Spring Boot**: A robust framework for building RESTful APIs, ensuring a solid foundation for scalable and efficient backend services.
- **H2 Database**: A lightweight, persistent database solution for fast development and testing.
- **Docker**: Containerization for consistent deployment across multiple environments, enhancing the application's portability and scalability.
- **JUnit 5 & Mockito**: Industry-standard tools for unit and integration testing, ensuring high-quality, reliable code.
- **Maven**: A build automation tool for dependency management and project builds.
- **Postman**: Used for API testing, ensuring all endpoints are functioning as expected.
- **Render**: Cloud platform for application deployment, providing a reliable environment for production and testing.
- **UptimeRobot**: Monitors API health, ensuring the application is live and responsive 24/7.
- **Java 21**: Leveraging modern features of Java for backend development with an emphasis on object-oriented programming (OOP).

## CI/CD Pipeline
- **GitHub Actions**: Integrated CI/CD pipeline automating build, test, and deployment processes. This ensures that the application is always up to date with the latest changes, with no manual intervention required for deployment.


## API Endpoints
## 1. Get All Waste Categories

Live endpoint:   [ **https://enviro365.onrender.com/api/waste/categories**](https://enviro365.onrender.com/api/waste/categories)   
        
- Method: GET
- Description: Retrieves a list of all waste categories, including their details and associated recycling tips.
- Response:

       
       {
       "name": "metal",
       "description": "hard object that can be attracted by a magnet",
       "creationTime": "2025-01-13T10:26:17.219285",
       "recyclingTips": ["recycle", "separate from non-metal waste"]
       },
       {
       "name": "plastic",
       "description": "non-biodegradable material",
       "creationTime": "2025-01-13T10:30:10.123456",
       "recyclingTips": ["clean before recycling", "avoid single-use plastics"]
       }
## 2. Update Category Description/Dispose guideline

**/api/waste/categories/{CategoryID}**]
        
- Method: PUT
- Description: Update an existing dispose guideline.
- Request Body:

       
       {
       "id": 1,
       "description": "non-biodegradable material",
       },

Response:

       {
       "name": "plastic",
       "description": "non-biodegradable material",
       "creationTime": "2025-01-13T10:30:10.123456",
       "recyclingTips": ["clean before recycling", "avoid single-use plastics"]
       }

## 3. Delete Category by id

**URL: /api/waste/categories/{CategoryID}**

- Method: Delete
- Description: Deletes category by id and its referenced Recycling Tips if applicable
- Response: No content

## 4. Add a New Waste Category

**URL: /api/waste/categories**
- Method: POST
- Description: Adds a new waste category to the system.
- Request Body:

       {
       "name": "glass",
       "description": "fragile and recyclable material"
       }

   Response:

        {
          "category": {
            "name": "glass",
            "description": "fragile and recyclable material",
            "creationTime": "2025-01-14T11:00:00.000000",
            "recyclingTips": []
          }
        }

## 5. Get All Recycling Tips

Live endpoint:   [ **https://enviro365.onrender.com/api/waste/tips**](https://enviro365.onrender.com/api/waste/tips)   
   - Method: GET
   - Description: Retrieves a list of all recycling tips across categories.
   - Response:

   
       {
       "recyclingTip": "Recycle plastic bottles separately",
       "category": "plastic"
       },
       {
       "recyclingTip": "Clean glass containers before recycling",
       "category": "glass"
       }
   

## 6. Add a New Recycling Tip

**URL: /api/waste/tips**
- Method: POST
- Description: Adds a new recycling tip to a specific waste category.
-  Request Body:

       {
       "recyclingtip": "Avoid contamination with food waste",
       "category": {
              "id": 1
          }
       }

      Response:

       {
       "recyclingTip": "Avoid contamination with food waste",
       "category": "plastic"
       }

Error Handling

The application includes error handling for common issues:



## Future Improvements

Add authentication and authorization for user roles (admin, student, etc.).
Integrate **AI** to recommend dispose guidelines & recycling tips, include chatbot for information
Implement search and filtering functionality for categories and tips.
Enhance the UI to integrate with the backend using a framework like React or Angular.

