# rabbitqueue-restaurant-booking

<h2>Introduction</h2>
<p>I created this project in 2019 to implement and get thourough understanding of RabbitMQ </br>
</p>

<h3>Getting Started</h3>
<ol>
  <li>Clone this project and import into your IDE.</li>
  <li>To connect with mysql, refer application.properties. The DB folder contains queries you need to run the project. Create a database and exceute the queries.</li>
  <li>Now you are good to go.</li>
  </ol>
  
  <h3>Overview</h3>
  <p>Refer the following link to understand the scope of the project.</p>
  https://erarica-mehra.medium.com/rabbitmq-a-restaurant-booking-application-using-spring-boot-c7f3fac01ee
  
  <h3>EndPoints</h3>
  <p> Execute the following endpoints from Postman </p>
  <ol>
  <li>POST : localhost:8080/booking/send</li>
  Sample request: </br>
  <code>
  {
  "userName": "Alice",
  "restaurant":"Jungle Cafe",
  "text":"options",
  "to" : "abc@gmail.com",
  "from" : "arf.cm@gmail.com",
  "subject" : "Sub : Book a table",
  "date": "2020-12-12",
  "slot": "2 pm"
} 
  </code> </br>
  <li>POST : http://localhost:8080/booking/approve/{id}/{status}</li>
  </ol>
  
<h3>Built With</h3>
<ol>
  <li>Java</li>
  <li>MySQL</li>
  <li>Spring Boot</li>
  <li>RabbitMQ</li>
  </ol>
    
<h3>Author</h3>
<p>Erarica Mehra</p>
