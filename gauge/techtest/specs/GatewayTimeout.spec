GatewayTimeout
==============

tags: gateway_timeout

|id|  text                |
|--|----------------------|
|1 |{\"test\":123}        |
|2 |{\"test\":"1234abc&&"}|
|3 |{\"test\":"Abc"}      |
|4 |{\"test\":"^&*("}     |

* Get to the "manage/health" endpoint
* Then the response will be "OK"
* The response code should be "200"

This spec file details the interaction with the gateway_timeout endpoint and the expected results
of those actions
     
Gateway_timeout is returned when doing a POST to the /gateway_timeout endpoint
------------------------------------------------------------------------------

* Post to the "gateway_timeout" endpoint
* Then the response will be "Service Unavailable"
* The response code should be "503"

OK is returned when doing a GET to the /gateway_timeout endpoint
----------------------------------------------------------------

* Get to the "gateway_timeout" endpoint
* Then the response will be "OK"
* The response code should be "200"

Details of the last response is returned when doing a GET to /gateway_timeout/last endpoint
-------------------------------------------------------------------------------------------

* Post to the "gateway_timeout" endpoint with <text>
* Then the response will be "Service Unavailable"
* Retrieve the latest post details from the "gateway_timeout/last" endpoint
* The last updated time returned should be equal to the posted time
* The media type returned should be "application/json"
* The body text returned should be <text>
