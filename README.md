# Enviro365 Waste Sorting Application

## Live Website http://localhost:63342/Enviro365/assessment/static/index.html
**LIVE webservice/API** https://enviro365.onrender.com
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

- **Java 21**: For the backend development.
- **Spring Boot**: For creating RESTful APIs.
- **H2 Database**: In-memory database for quick development and testing.
- **Docker**: For containerizing the application and ensuring seamless deployment.
- **JUnit 5** and **Mockito**: For unit and integration testing.
- **Maven**: For managing project dependencies and builds.
- **Postman**: For testing the APIs.



[//]: # ()
[//]: # (This project is built using Spring Boot and exposes RESTful APIs for interaction.)

[//]: # (Features)

[//]: # ()
[//]: # (    Retrieve all waste categories with detailed information.)

[//]: # (    Add new waste categories.)

[//]: # (    Fetch all recycling tips.)

[//]: # (    Add new recycling tips for specific waste categories.)




## API Endpoints
## 1. Get All Waste Categories

[   **URL: /api/waste/categories**]()   
        
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
## 2. Delete Category by id

[   **URL: /api/waste/categories/{CategoryID}**
]()   
- Method: Delete
- Description: Deletes category by id and its referenced Recycling Tips if applicable
- Response: No content

## 3. Add a New Waste Category

[   **URL: /api/waste/categories**
]()   
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

## 4. Get All Recycling Tips

[   **URL: /api/waste/tips**]()   
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
   

## 5. Add a New Recycling Tip

[   **URL: /api/waste/tips**
]()   
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
    Implement search and filtering functionality for categories and tips.
    Enhance the UI to integrate with the backend using a framework like React or Angular.

