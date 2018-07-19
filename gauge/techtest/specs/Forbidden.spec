Forbidden
=========

tags: forbidden

|id|  text                |
|--|----------------------|
|1 |{\"test\":123}        |
|2 |{\"test\":"1234abc&&"}|
|3 |{\"test\":"Abc"}      |
|4 |{\"test\":"^&*("}     |

* Get to the "manage/health" endpoint
* Then the response will be "OK"
* The response code should be "200"

This spec file details the interaction with the forbidden endpoint and the expected results
of those actions
     
Forbidden is returned when doing a POST to the /forbidden endpoint
------------------------------------------------------------------------------

* Post to the "forbidden" endpoint
* Then the response will be "Forbidden"
* The response code should be "401"

OK is returned when doing a GET to the /forbidden endpoint
----------------------------------------------------------------

* Get to the "forbidden" endpoint
* Then the response will be "OK"
* The response code should be "200"