# FlightsBookingSystem
BrightSkies Task


CONFIG
In application.properties change datasource username and pass to your postgres username and pass
for first run change spring.jpa.hibernate.ddl-auto = update to spring.jpa.hibernate.ddl-auto = create 
change it back after first run 
A couple of users and a couple of flights will be added to the db for the first time the application runs using the file: imports.sql


Change "flightsdb" in spring.datasource.url=jdbc:postgresql://localhost:5432/flightsdb to the name of your test db



In postman use the following to test:

GET: /flights //Lists all flights
GET: /flights/{uid} //Gets a flight information by its id
POST: /flights and select (body/form-data) option with the following paramters: "location" String, "destination" String ,
"arrivaltime" Date with the following format: 1999-01-08 04:05:06, "departure" Date same format, "fare" int
// this path creates a new flight with those input params

PUT: /flights paramters: "location" String, "destination" String ,
"arrivaltime" Date with the following format: 1999-01-08 04:05:06, "departure" Date same format, "fare" int

// this path modifies an existing flight's details

DELETE: /flights // deletes a flight
GET: /flights/search paramters: "location" String, "destination" String  //searches for all flights between two locations


GET: /users //Lists all users
GET: /users/{UID} //finds a user by his id
POST: /users Params: "name" String , "type" boolean (0 = normal user, 1 = admin) //creates a new user
PUT: /users Params: "name" String , "type" boolean //modifies an existing user
DELETE: /users Params: "id" //deletes a user by his id


GET: /userflights //lists all flights booked by users
POST: /userflights/bookflight Params: "UID" int ,"FID" int , "tickettype" boolean (0 = Economy class, 1 = First Class)
// books a new flight using user id and flight id
GET: /userflights/user Params: "uid" int //Lists all flights booked by a certain user
DELETE: /userflights/user Params: "uid" int //deletes all flights booked by a certain user
DELETE: /userflights/user/flight Params: "uid" int, "fid" int //cancels a flight for a certain user using flight id and user id
POST: /userflights/user/flight Params: "uid" int, "fid" int, "tickettype" boolean 
//changes booked ticket type to "tickettype" (upgrades or downgrades ticket)




