##############################
Serviceentwicklung / Backend
 
To run application
Go to \backend
mvn -f pom.xml clean package
docker build -f Dockerfile -t backend .
docker run --publish 8086:8086 backend
Open Postman for the page ans use this page http://localhost:8086/users
GET http://localhost:8086/users
PUT http://localhost:8086/users/5 with {"id": "5", "firstName": "Max","lastName": "Bauer","email": Max.Bauer@gogole.de"}
Oder POST  http://localhost:8086/users{"id": "50","firstName": "Max","lastName": "Bauer","email": Max.Bauer@gogole.de" }


##############################
UI & Frontendentwicklung
Go to \frontend
npm install and npm start
open http://localhost:3000/ and keeping run backend
