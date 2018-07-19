NoResponse
==========

tags: no_response

|id|  text                |
|--|----------------------|
|1 |{\"test\":123}        |
|2 |{\"test\":"1234abc&&"}|
|3 |{\"test\":"Abc"}      |
|4 |{\"test\":"^&*("}     |

* Get to the "manage/health" endpoint
* Then the response will be "OK"
* The response code should be "200"

This spec file details the interaction with the no_response endpoint and the expected results
of those actions
     
No Response is returned when doing a POST to the /no_response endpoint
----------------------------------------------------------------------

* Post to the "no_response" endpoint
* Then the response will be "No Content"

OK is returned when doing a GET to the /no_response endpoint
------------------------------------------------------------

* Get to the "noresponse" endpoint
* Then the response will be "OK"
* The response code should be "200"

Details of the last response is returned when doing a GET to /no_response/last endpoint
---------------------------------------------------------------------------------------

* Post to the "no_response" endpoint with <text>
* Then the response will be "No Content"
* Retrieve the latest post details from the "no_response/last" endpoint
* The last updated time returned should be equal to the posted time
* The media type returned should be "application/json"
* The body text returned should be <text>
