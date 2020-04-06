# Music Finder
  
Simple application with a REST API to store and retrieve information about Artists and Albums.

# How to use this api ?

|Description            | URL                                     | Request                 |
| ----------------------|:----------------------------------------|:------------------------| 
|Save the new artist    |POST http://localhost:8080/artists       | {"name":"Stephanie"}    |
|Update existing artist |PUT http://localhost:8080/artists/{artistId}        | {"name":"ARRhman"}      |
|Return of all artists  |GET http://localhost:8080/artists        |       |
|search artist with name|GET http://localhost:8080/artists?searchTerm={artistName}  ||
|Save the new album    |POST http://localhost:8080/{artistId}/albums       | {<br>"title": "perfect",<br>"yearOfRelese" : "1967"<br>"genres" : "Rhythm"}    |
|Update existing album |PUT http://localhost:8080/artists/{artistId}/albums/{albumId}        | {<br>"title": "perfect",<br>"yearOfRelese" : "1967"<br>"genres" : "Rhythm"}     |
|Return all albums for artist  |GET http://localhost:8080/artists/{artistId}/albums/{albumId}        |       |


#Feature status

|Feature| Status |Difficulty Level |comments|
|-------|:-------|:----------------|:-------|
|ADD get,create,update enpoints for album|completed|easy||
|ADD get,create,update enpoints for artist|completed|easy|| 
|Implement filtering,searching,pagination for artist|completed|easy||
|Implement filtering,searching,pagination for album|not completed|easy|Impementation is same as it is for artist |
|Integration with discogs|not completed ||not able to access discogs api using consumer key and secret, authentication error|
|Expose metrics:<br>* Number of calls per endpoint<br>* Average processing time per endpoint<br> * Time taken to call Discogs|not completed|easy||
|Reactive implementation|not completed|||
|Dockerize your application|not completed|||
 
# Technology Stack:
  * Java 1.8s
  * Spring Boot, Spring Actuator

# Prerequisites:
  * Install Java 8
  * Install Maven build tool

# How to setup this application locally ?
  1. Clone the repository from command line using below command
      git clone https://github.com/sayali-kotkar/music-database.
  2. Run mvn spring-boot:run command from the project folder using command prompt/terminal.
  
  
# Application Metrics

Basic application metrix can be  accessed using Actuator URLs

http://localhost:8080/actuator/health

http://localhost:8080/actuator/info

http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/trace



