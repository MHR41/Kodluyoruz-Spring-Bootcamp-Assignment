# 'Spring Boot' Bootcamp Assignments
----
# First Aassignment : Grocery Store
#### This program desinged for holder of a grocery store which can go to distributor and buy his/her products, then return and get orders from customers to sell them. The owner of store can go to distributor at any time that he/she wants.

# Second Aassignment : Flight Ticket Sales 
#### This project's aim is to design a good OOP logic for flights from different airlines. Our program like real world in travel agencies should give information about the flights to the passenger and sell plane ticket to them. Every airline has it's own principle (like ticket price, discount, luggage weight, ...)

# Third And Fourth Aassignments : API for second assignment
#### The following picture is an example of ticket sold to the passenger considering the related airline principles.
![ticket](https://user-images.githubusercontent.com/91452487/167321654-92841602-6b80-4acc-bfb3-f319b0d5b241.PNG)


# Final Project : IMDb simulation

## Project is a simulation of IMDb site, which gives information about the movies to the user.

## Used Technologies
*Maven*

*Lombok*

*H2 Database*

## Required Installations
+ JDK 1.8
+ Apache Maven
+ Spring Boot 2.6.7

## How To Run The Project ?
#### You can type the following commands to run the project
+ `mvn spring-boot:run`
+ `mvn install / mvn clean install`
+ `mvn spring-boot:run`
#### After that the server will be avilable on http://localhost:8085 

## Database Connection
#### H2 Database used for this project. You can add the following configuration to your application.properties file in resources directory
```
server.port=8085
spring.datasource.url=jdbc:h2:mem:PrivateDB
spring.datasource.driverClassName= org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=1
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

## What does project do ?
### The user can get information about the movies which he/she wants to watch. Project works like IMDb, help people to watch their favorite movies. 
+ New films can be added to data base, can be searched, actors/actress of the movie can be searched, rate of the movie can be checked
+ New actor/actress can be added to databse, deleted and searched from database 
+ The user can like films he/she watches, and rate them

## Architecture of workflow int the project
#### Projet consist of 3 main major layers(Controller, Business, Respository). Design was done in a way that each layer has it's own domain entity, and does not have any information about the other layers.
#### For sending or recieving data bitween layers, each layer must use domain entity of the intended leyer. Abstraction was done bitween each layer that makes the project flexible for future needs and changes.
#### The following picture makes much more clear the relationship bitween layers
![t](https://user-images.githubusercontent.com/91452487/167318500-416d79e8-bade-4397-a089-c6274954ee35.png)




