## Description
Service Development / Backend
Build a RESTful service in JAVA that allows to create a user with a first name, last name and email address. Furthermore, the service should make it possible to read and update the user's data and delete users. It is sufficient to store the data in the working memory. Techstack: Java + Spring MVC(*Model — View — Controller*) and React.js

UI & front-end development
Build a browser app in JS, React.js, it allows to create a user with a first name, last name and email address. The browser app should make it possible to read the user's data, update it and delete users. It is sufficient to save the data in the browser.  Providing tests with Jest 

# How to start
## Serviceentwicklung / Backend

To run application: 
Go to \backend
### `mvn -f pom.xml clean package`
### `docker build -f Dockerfile -t backend .`
### `docker run --publish 8086:8086 -it backend` 

Open Postman for the page ans use this page http://localhost:8086/users
GET http://localhost:8086/users
PUT http://localhost:8086/users/5 with {"id": "5", "firstName": "Max","lastName": "Bauer","email": Max.Bauer@google.de"}
Oder POST  http://localhost:8086/users{"id": "50","firstName": "Max","lastName": "Bauer","email": Max.Bauer@google.de" }

## UI & Frontendentwicklung
To run application:
Go to \frontend
### `npm install` and 
### `npm start`
open http://localhost:3000/ and keeping run backend
