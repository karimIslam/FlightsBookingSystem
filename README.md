# FlightsBookingSystem
BrightSkies Task


CONFIG<br/>
In application.properties change datasource username and pass to your postgres username and pass<br/>
for first run change spring.jpa.hibernate.ddl-auto = update to spring.jpa.hibernate.ddl-auto = create <br/>
change it back after first run <br/>
A couple of users and a couple of flights will be added to the db for the first time the application runs using the file: imports.sql<br/>


Change "flightsdb" in spring.datasource.url=jdbc:postgresql://localhost:5432/flightsdb to the name of your test db<br/>



In postman use the following to test:<br/>

GET: /flights //Lists all flights<br/>
GET: /flights/{uid} //Gets a flight information by its id<br/>
POST: /flights and select (body/form-data) option with the following paramters: "location" String, "destination" String ,<br/>
"arrivaltime" Date with the following format: 1999-01-08 04:05:06, "departure" Date same format, "fare" int<br/>
// this path creates a new flight with those input params<br/>

PUT: /flights paramters: "location" String, "destination" String ,<br/>
"arrivaltime" Date with the following format: 1999-01-08 04:05:06, "departure" Date same format, "fare" int<br/>

// this path modifies an existing flight's details<br/>

DELETE: /flights // deletes a flight<br/>
GET: /flights/search paramters: "location" String, "destination" String  //searches for all flights between two locations<br/>


GET: /users //Lists all users<br/>
GET: /users/{UID} //finds a user by his id<br/>
POST: /users Params: "name" String , "type" boolean (0 = normal user, 1 = admin) //creates a new user<br/>
PUT: /users Params: "name" String , "type" boolean //modifies an existing user<br/>
DELETE: /users Params: "id" //deletes a user by his id<br/>


GET: /userflights //lists all flights booked by users<br/>
POST: /userflights/bookflight Params: "UID" int ,"FID" int , "tickettype" boolean (0 = Economy class, 1 = First Class)<br/>
// books a new flight using user id and flight id<br/>
GET: /userflights/user Params: "uid" int //Lists all flights booked by a certain user<br/>
DELETE: /userflights/user Params: "uid" int //deletes all flights booked by a certain user<br/>
DELETE: /userflights/user/flight Params: "uid" int, "fid" int //cancels a flight for a certain user using flight id and user id<br/>
POST: /userflights/user/flight Params: "uid" int, "fid" int, "tickettype" boolean <br/>
//changes booked ticket type to "tickettype" (upgrades or downgrades ticket)<br/>




