# SportsManagementSystem (Backend part)

The project is a Sports Event Management Portal that manages the creation and management of a sports event. It makes it easier to maintain the different aspects of a sports event. The portal provides various functionalities like creating events for various sports, request for participation, etc.

# Requirements
REQ_01 	Sports Event  Service	This Module is a Middleware Microservice that performs following operations: 
•	View all the Sports
•	View sports by name
•	Create and cancel the events (based on sports name)
•	View all Events and search event by name
REQ_02 	Player Service 	This Module is a Middleware Microservice that performs the following operations: 
•	Add the player (based on sports name)
•	Remove the players
•	View all the players 
REQ_03 	Participation Service 	This Module is a Middleware Microservice that performs the following operations by using the sports event service and player service.
•	Request for the participation on behalf of players for the particular event.
•	View the participation request
•	Update the participation status as per the event requirement
•	List the participation request based on approved/ declined /pending status separately.
REQ_04 	Authorization service 	This microservice is used with anonymous access to Generate JWT 
REQ_05 	Sports Event  Management portal 	A Web Portal that allows a member to Login and allows to do following operations: 
•	Login 
•	Add / remove the player
•	Add / remove  the Event
•	View all the Players 
•	View all the Events
•	Request for the participation 
•	View all the participation requests  then Approve or decline the request
•	View the Approved / Declined /pending status 

# Made with spring boot
