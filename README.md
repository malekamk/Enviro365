# Enviro365 Waste Sorting Application

## Live Website https://environment365.onrender.com
## Overview

The **Enviro365 Waste Sorting Application** is an innovative solution aimed at promoting sustainable waste management practices, 
The backend is supported by  persistent file based **H2 database** instead of an in-memory  for rapid development and testing, while **Docker** is used to containerize the application for ease of deployment.

## Key Features

- **Waste Category Management**: Manage waste categories such as "Plastic", "Metal", "Glass", etc.
- **Disposal Guidelines**: Retrieve guidelines on how to dispose of different waste categories.
- **Recycling Tips**: Provide tips on how to recycle materials properly.
- **Input Validation**: Ensure that all incoming data meets the necessary requirements.
- **Dockerized**: The application is containerized for easy deployment.
- **In-Memory Database (H2)**: An H2 database is used for development, ensuring quick and simple setup.

## Technologies Used

- **Spring Boot**: For creating RESTful APIs.
- **H2 Database**: Persistent database for quick development and testing.
- **Docker**: For containerizing the application and ensuring seamless deployment.
- **JUnit 5** and **Mockito**: For unit and integration testing.
- **Maven**: For managing project dependencies and builds.
- **Postman**: For testing the APIs.
- **Render**: For deploying application.
- **UptimeRobot**: For API monitoring.
- **Java 21 (Object Orientated Programming)**: For the backend development.

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

[URL: **/api/waste/categories/{CategoryID}**]()   
        
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

[   **URL: /api/waste/categories/{CategoryID}**
]()   
- Method: Delete
- Description: Deletes category by id and its referenced Recycling Tips if applicable
- Response: No content

## 4. Add a New Waste Category

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
Integrate **AI** to recommend dispose guidelines & recycling tips, include chatbot for information
Implement search and filtering functionality for categories and tips.
Enhance the UI to integrate with the backend using a framework like React or Angular.

