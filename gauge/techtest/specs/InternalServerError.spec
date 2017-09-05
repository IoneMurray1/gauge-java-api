Internal Server Error
=====================

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

|id|  text                |
|--|----------------------|
|1 |{\"test\":123}        |
|2 |{\"test\":"1234abc&&"}|
|3 |{\"test\":"Abc"}      |
|4 |{\"test\":"^&*("}     |

* Get to the "manage/health" endpoint
* Then the response will be "OK"
* The response code should be "200"

OK is returned when doing a GET to the /internal_server_error endpoint
----------------------------------------------------------------

* Get to the "internal_server_error" endpoint
* Then the response will be "OK"
* The response code should be "200"

Internal Server Error is returned when hitting the /internal_server_error endpoint
----------------

* Post to the "internal_server_error" endpoint
* Then the response will be "Internal Server Error"
* The response code should be "500"

Details of the last response is returned when doing a GET to /internal_server_error/last endpoint
-------------------------------------

* Post to the "internal_server_error" endpoint with <text>
* Then the response will be "Internal Server Error"
* Retrieve the latest post details from the "internal_server_error/last" endpoint
* The last updated time returned should be equal to the posted time
* The media type returned should be "application/json"
* The body text returned should be <text>
