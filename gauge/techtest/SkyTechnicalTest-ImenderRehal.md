Sky Technical Test - Imender Rehal
===================

Part 1 - Setup
-------------
Setup for straight forward, with the following changes and workarounds:

1. Enable hardware virtualisation in Bios in order to get Docker running
2. Unable to point to localhost on windows because of this issue:
https://blog.sixeyed.com/published-ports-on-windows-containers-dont-do-loopback/ 

Workaround was to use the docker ip in the address and change the api calls to see the tests running and debug them.

Part 2 - Documentation Review 
-------------
The following needs correcting in the API documentation:

1. **/unauthorized** - This route is duplicated and one of them should be removed
2. **Get/no_response** – Response should be '*Status 200 OK*' and not '*Status 200 No Content*'
3. **Post/Bad_request**  - documentation text should be “This url will return you a *400 Bad Request* response code when you try to do a POST request and return some sample json” and not “This url will return you a *503 Gateway timeout* response code when you try to do a POST request and return some sample json”
4. **Get/forbidden** – Response should be '*Status 200 OK*' and not '*Status 200 Forbidden*'
5. **Get/gateway_timeout** – Response should be '*Status 200 OK'* and not '*Status 200 Gateway timeout*'
6. **Gateway_timeout** - The http code for Gateway timeout is 504. For 503 it's Service Unavailable. Which one is part of the requirements? If it's Gateway_timeout then any references to code 503 should be updated to 504. If it's Service Unavailable that is part of the requirements, then Gateway_timeout route needs to be removed and/or replaced with Service_unavailabe route to represent this
7. **/madeup**  - For consistency, this route is missing the available methods GET

Part 3 - Exploring the API
-------------
**Get/last** - When hitting the last route to retrieve the date/time for the latest POST (http://localhost:3000/unauthorized/last) , the server time does not factor in daylight savings. For example a call made at 2017-09-02T10:57:54Z is showing as 2017-09-02T09:57:54Z

Get/last can actually be called by the api route followed by any character. for example http://localhost:3000/gateway_timeout/asdlksmflsmdfsd returns the same response as http://localhost:3000/gateway_timeout/last - requires further questions and investigation

**Post/gateway_timeout** - response code is 503 Service Unavailable and not 503 Gateway timeout as the documentation states. The documentation should be updated to represent this route if it's part of the requirements, and not 504 gateway timeout

**Post/unauthorized** - The response received includes receivedRequest entity as follows which is not included in the documentation:

    { "unauthorised": [ { "statusCode": 401, "error": "Unauthorized", "message": "Invalid token", "attributes": { "error": "Invalid token" } }, { "receivedRequest": [ { "test": 123 } ] } ] }

**Get/unauthorized/last** - the response returned includes mediaTypeUsed and  bodyReceived entities which are not included in the documentation:

    {"unauthorized": [{"lastUpdated": "2017-09-03T15:45:01Z"}, {"mediaTypeUsed": "application/json","bodyReceived": {"test": 123}}]}

**Additional scenarios tested:**
1. POST - Modified request body to include additional digits - valid
2. POST - Modified request body to include additional chars - valid
3. POST - with blank request - valid (no validation included) - valid
4. Tested with invalid URLs - 404 not found
5. POST - with different message body types, text, text/plain, application/json and application/javascript - valid

Part 4 - Automation Tests
-------------
 - Removed Asserions.java - duplicate method was causing validation
   errors when running tests
 - Fixed failing tests - BadRequest and MadeUp
 - Added additional test to InternalServerError
 - Implemented assertion to compare the time of the post to the time in the get/last 
 - Implemented assertion to compare the body text in the post and get/last response
 - Implemented assertion to compare the format used in the post and get/last response
 - Added data table to post <text> and retrieve the same data in get/last response
 - Added context steps to do a health check of API

Part 5 - Further Testing
-------------
- Post/unauthorised - Assert response body which includes additional data including the request body
- POST - with different message body types, text, text/plain, application/json and application/javascript - valid
- POST - with blank data in the message body 
- Post/unauthorised - Post with valid authorisation headers/token
