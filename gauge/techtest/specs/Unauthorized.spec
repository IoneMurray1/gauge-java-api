Unauthorized
============

tags: unauthorised

|id|  text                |
|--|----------------------|
|1 |{\"test\":123}        |
|2 |{\"test\":"1234abc&&"}|
|3 |{\"test\":"Abc"}      |
|4 |{\"test\":"^&*("}     |

* Get to the "manage/health" endpoint
* Then the response will be "OK"
* The response code should be "200"

This spec file details the interaction with the unauthorised endpoint and the expected results
of those actions
     
Unauthorized is returned when doing a POST to the /unauthorized endpoint
------------------------------------------------------------------------

* Post to the "unauthorized" endpoint
* Then the response will be "Unauthorized"
* The response code should be "401"

OK is returned when doing a GET to the /unauthorized endpoint
-------------------------------------------------------------

* Get to the "unauthorized" endpoint
* Then the response will be "OK"
* The response code should be "200"

Details of the last response is returned when doing a GET to /unauthorized/last endpoint
----------------------------------------------------------------------------------------

* Post to the "unauthorized" endpoint with <text>
* Then the response will be "Unauthorized"
* Retrieve the latest post details from the "unauthorized/last" endpoint
* The last updated time returned should be equal to the posted time
* The media type returned should be "application/json"
* The body text returned should be <text>
