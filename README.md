# TUber

There are 3 urls for this application.

1. http://localhost:8080/TUber/cabBooking/bookCab?email=testmail&latitude=1&longitude=2&cabColour=1

This url is to book the car. 
Parameters:-
email- customer email Id
latitude - Only integers
longitude - Only integers
cabColour - Ex - 1 is for pink color

If cab is available it will book cab and it will return the cab id. Cab Id is our reference for to end the ride. 

2. http://localhost:8080/TUber/cabBooking/endCab?cabId=x1y201&latitude=26&longitude=-20

This url is to end the ride.
cabId= Booked Cab ID
latitude = End location 
longitude = end location 

This url will return cab charges

3. http://localhost:8080/TUber/cabBooking/availCabs

This url is used to  get all available cabs with location and cab colour. It wil be returned as Json
