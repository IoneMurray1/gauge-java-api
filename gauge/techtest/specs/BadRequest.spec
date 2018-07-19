BadRequest
==========

tags: bad_request

|id|  text                |
|--|----------------------|
|1 |{\"test\":123}        |
|2 |{\"test\":"1234abc&&"}|
|3 |{\"test\":"Abc"}      |
|4 |{\"test\":"^&*("}     |

This spec file details the interaction with the bad_request endpoint and the expected results
of those actions

* Get to the "manage/health" endpoint
* Then the response will be "OK"
* The response code should be "200"
     
Bad Request is returned when doing a POST to the /bad_request endpoint
----------------------------------------------------------------------

* Post to the "bad_request" endpoint
* Then the response will be "Bad Request"
* The response code should be "400"

OK is returned when doing a GET to the /bad_request endpoint
------------------------------------------------------------

* Get to the "bad_request" endpoint
* Then the response will be "OK"
* The response code should be "200"