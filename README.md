# Music Finder
  
Simple application with a REST API to store and retrieve information about Artists and Albums.

# How to use this api ?
  1. Hit below url to get the result for your search criteria against apple itune and google books api.
       http://localhost:8888/media?searchString={input_term}
  2. This api will by default return maximum of 5 books and maximum of 5 albums related to input term.     
  3. API can be configured to return more number of records by passing limit parameter in url.
  		http://localhost:8888/media?searchString={input_term}&limit={limit}
  	 where limit is no of records expected in response for each mediaType. e.g if limit parameter is 10, response will contain 10 records for books and 10 record for album.
  
# Technology Stack:
  * Java 1.8
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

