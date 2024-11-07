## Title

> The UNCG Group Fitness App

## Team Members

> Trinity Boler, Jennifer Galicia-Torres, and Natalie Hildreth


## Description
The UNCG Group Fitness App is an application that allows UNCG students to sign up for different fitness classes provided by class instructors. 
Students are able to see the materials needed and/or provided for each class, as listed by the instructor under each class description. Instructors can create, delete, and modify classes. They can then schedule classes at specific times for students to pick. Administrators can oversee messages and classes, allowing them to flag and delete content. 
The motivation for this app is to encourage UNCG students to improve their health and well-being. Our main goal is to give individuals the opportunity to select the fitness class that they feel most comfortable with. Scheduling a fitness course will be based on their availability, comfort level, fitness instructor, and level of fitness. 
The UNCG Group Fitness App will help to solve the issue of availability issues. Therefore, individuals will now have the opportunity to schedule a fitness course based on their availability, intensity of the fitness course, and comfortability with the instructor.
﻿

User

A user is a person who signs up for the site and can enroll in classes. Each user can have one of three roles: Customer, Instructor, or Admin.

﻿

POST

http://localhost:8080/users/new

create new user

﻿

GET

http://localhost:8080/users/all

fetch all users

﻿

Classes

The classes are fitness classes that customers can sign up for, and instructors can create and modify.

﻿

POST

http://localhost:8080/classes/new

create new class

﻿{
       "creatorId": 1,
       
       "title": "Core Pilates",
       
       "details": "A Pilates class designed to strengthen the core and improve flexibility.",
       
       "date": "2024-11-14",
       
       "startTime": "17:30:00",
       
       "endTime": "19:00:00",
       
       "level": "Intermediate",
       
       "instructorName": "Emily Johnson",
       
       "status": "Available",
       
       "imagePath": "/images/core_pilates.jpg",
       
       "createdAt": "2024-10-28",
       
       "updatedAt": "2024-10-31"

}


GET

http://localhost:8080/classes/all

fetch all classes

﻿

GET

http://localhost:8080/classes/search?title=Hi

Search for class part of name no contrarians.

﻿


GET

http://localhost:8080/classes?title=High-Intensity Interval Training

Search class by full name

﻿

GET

http://localhost:8080/classes/levels?level=Advanced

Search class by the level of class:
Beginner, Intermediate, Advanced

﻿

PUT

http://localhost:8080/classes/update/2

modify class

﻿{
        "classId": 2,
        
        "creator": null,
        
        "title": "High-Intensity Interval Training",
        
        "details": "A fast-paced workout focused on high-intensity intervals to burn fat.",
        
        "date": "2024-11-14",
        
        "startTime": "07:00:00",
        
        "endTime": "08:00:00",
        
        "level": "Advanced",
        
        "instructorName": "Mark Lee",
        
        "status": "Available",
        
        "imagePath": "/images/hiit_class.jpg",
        
        "createdAt": "2024-10-28",
        
        "updatedAt": "2024-10-29"
        
}

    
DELETE

http://localhost:8080/classes/delete/4

delete class

﻿

GET

http://localhost:8080/classes/INSTRUCTOR/2

seach class by creatorId


