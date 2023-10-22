Feature: Login page automation

@valid
Scenario: User should be able to login by useing valid Credential
Given User in login page
When User enter valid User name and password
And Click Login Button 
Then User is navigated to Home page
And close browser

@invalid
Scenario: User should not be able to login by useing valid Invslid credential
Given User in Login Page
When User Enter valid User Name and Invalid Password
And Click loggin button
Then User get error message
And close browser