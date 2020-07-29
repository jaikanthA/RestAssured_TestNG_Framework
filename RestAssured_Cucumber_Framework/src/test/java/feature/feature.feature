Feature: To verify API automation with Rest Assured

@Test1_GET
Scenario: To verify Rest service - GET Method
Given I Set GET Request API URI
When Send the GET HTTP Request
Then I receive valid Response

@Test2_POST
Scenario: To verify Rest service - POST Method
Given I set POST Request API URI
And Add request parameters
And Adding Request object and then adding Header
When Send the POST Request
Then Validate the Response
