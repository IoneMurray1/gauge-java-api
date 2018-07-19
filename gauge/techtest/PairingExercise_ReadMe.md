Pairing Exercise
===================

The purpose of this exercise is to understand your approach handling new information, problem solving and interactions whilst pairing. It will last around 30-40 min and will involve API testing through the use of Postman and automation.

Introduction
-------------
An API (Application Programmable Interface) is a set of functions and procedures that allow the creation of applications which access the features or data of an operating system, application, or other service. A web API has been developed in Ruby and is running in Docker.


Part 1 - Set up 
-------------
1.	Access the API with URL: **http://localhost:3000**
2.	Familiarise yourself with the APIs and documentation
3.	Use postman to try out the API requests. Whilst exploring, if you notice anything which is questionable, make a note of it to discuss later
4.	The documentation and implementation the following endpoints do not match. Determine what the difference is and whether the API or documentation is correct: 
      1. GET /no_response
      2. POST /bad_request
5.	Using IntelliJ IDEA, familiarise yourself with the automation framework and tests for the API. 

Part 2 - Pairing
-------------
1.	Run all tests using the command: **mvn gauge:execute -DspecsDir=specs**
2.	View the report by opening **reports --> index.html** in a browser
3.	Determine failing tests, why they are failing and fix tests
4.	There are some improvements which can be made to the tests. Have a look at **InternalServerError.spec*** and determine what can be improved.
5.	The steps for a test scenario are missing from **InternalServerError.spec**. Implement the scenario using the pre-defined steps and correct values.
