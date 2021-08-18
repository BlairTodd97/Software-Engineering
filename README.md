# SousChef
> We are developing a web-application that helps users start their cooking journey, receive cooking tips and advice as they cook, and store their recipes to keep for future reference, or share to their friends! The contributors to this web-app are: Johana Di Girolamo, Blane Rhodes, Mary Kathryn Livingston, Blair Todd, and Tristan Wells. We are focusing on young adults who are entering the world of cooking - whether that be for health purposes, or because it's their first time having to cook for themselves - and we hope to guide these users to make smarter and more efficient decisions while they cook. We hope to impact thsoe who truly case about what they put in their bodies and how tasty it is!

# Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Demo](#demo)
* [Status](#status)
* [Some Cool Information](#some-cool-information)
* [Contact](#contact)

## General info
To make this web-app successful, we are only lacking time and a budget! :)

Here is our icon: ![CURRENT ICON](./src/main/resources/images/icon.jpg)

## Screenshots
TBD

## Technologies
* Backend Framework: Java Spring DATA REST
* Backend Testing: JUnit, Mockito
* Backend DB: H2 with JPA (H2 is a relational DB)
* Frontend Framework: React using JSX and ES6 JS
* Frontend Testing: Postman
* Environment Tech: Maybe Docker, Gradle (not Maven), IntelliJ

## Setup
To access our web-app, go to: (TBD)

## Features
List of features ready and TODOs for future development

* [TIPS] Get cooking tips as you browse the web-app!
* [SOCIAL MEDIA] Share your recipes to your friends and family!
* [KNOWLEDGE] Learn to cook more efficiently and tasty!

To-do list:

* Create a user-friendly front-end to welcome new users and start their new journey to cook
* Create a functional database of recipes and tips that can be given from the get-go or at random points during app use

## Demo
* **Blane**: Finished and solidifed the database layout, created the routes for authentication, notes, and recipes (see these files under [Controllers](https://bitbucket.org/cs3398f20betazoid/souschefwebapp/src/master/src/main/java/souschef/app/base/controllers/)), and the corresponding postman test for each [here](https://bitbucket.org/cs3398f20betazoid/souschefwebapp/src/master/sousChef.postman_collection.json).
* **Blair**: Worked on user authentication with Blane, and attempted to work on mockito testing for project. However, was unable to get mockito to work correctly and opted for postman instead. ( Postman: https://bitbucket.org/cs3398f20betazoid/souschefwebapp/src/master/sousChef.postman_collection.json )  
* **Johana**: Worked on the README, and on the front-end connections using React. You can find [my contributions here](https://bitbucket.org/cs3398f20betazoid/souschefwebapp/src/master/src/souschef-react/). The README is found from what you are currently reading; I got help from teammates to provide correct information, but I was the one to type and push the changes. My contributions that are linked, (the sourschef-react folder) is a folder that provides all of the code managed by the front-end team. The **src** folder includes all of the current javascript and css files that contain our project. To run our program, you will have to download the entire repo, move to the souschef-react folder and run the command `npm start` to run a localhost build of our webapp.
* **Tristan**: Created UI template for web pages in addition to developing home page. Contributions: https://bitbucket.org/cs3398f20betazoid/souschefwebapp/src/master/src/souschef-react/src/homepage.html , https://bitbucket.org/cs3398f20betazoid/souschefwebapp/src/master/src/souschef-react/src/cover.css
* **Mary Kathryn**: Established the connection between the react-forms and the backend database. By controbution is here: https://bitbucket.org/cs3398f20betazoid/souschefwebapp/src/master/src/souschef-react/src/UserEdit.js

## Status
Project is: _in progress_; only a working homepage with simple functionalities so far. Determined date of release: Dec 15th, 2020.

* **Blane**: The backend is essentially finished. One thing to possibly add are test classes for the controllers for independent offline testing, but due to time (and somewhat redundancy) we opted just for postman testing.
* **Blair**: Due to backend being basically finished, the only thing left would be to create more test classes for controllers, but the team has chosen to use postman testing to accomplish this.
* **Johana**: Next step includes debugging changes during implementation of the new homepage, providing help in the backend (regarding a direct connection to the React-based frontend), and continue to work on time-management to assure success.
* **Tristan**: Currently developing more web pages in correlation to features discussed (i.e. user login, data search)
* **Mary Kathryn**: Now that the connection between front-end and back-end is established, we are working towards creating the more legitimate functions for the project, like a log in function and a create new user layout.

## Some Cool Information
Misc. Stuff That's Dope:
Lombok (Java) is super useful for making coding faster and getting boiler plate code out of the way. Using builders for DTOs is real nice.
Mockito (Java) is a testing library that mixes with JUnit to mock objects and make truly independent unit tests
Should probably figure out env files so everything isn't so hardcoded like it is right now

Here's the tutorial I'm using: https://spring.io/guides/tutorials/react-and-spring-data-rest
I swapped employees out for users so it looks more like stuff we would use. It does some decent explaining of stuff but it'd probably better to look into all of the separate stuff too.
The frontend stuff is going right alongside the backend stuff. I don't think that's how it would be done irl, but it makes it easier.
With Mockito (and this is mainly just for backend folks), using functional programming instead of OOP makes it a lot easier to test and mock.

## Contact
Created by Blane Rhodes, Johana Di Girolamo, Mary Kathryn Livingston, Blair Todd, & Tristan Wells



