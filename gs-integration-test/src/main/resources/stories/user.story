Narrative: As a developer I want to check these functions to make sure the flow is correct.

Scenario: Provide a valid username and valid password. I expect the token will be returned.
Given I create an account with email: test1@gmail.com, password: abcd1234 and confirmedPassword: abcd1234
And I call the api for login with test1@gmail.com and abcd1234
Then the token should be returned