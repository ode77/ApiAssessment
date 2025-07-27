@Animal
Feature:

  Scenario: Validation of positive response code, Get Animal from the Application as Authenticated User
    Given I am an authenticated user
    When I hit the get animal api url
    Then I get 200 as the response code

  Scenario:Validation of positive response body for Get Animal from the Application as Authenticated User
    Given I am an authenticated user
    When I hit the get animal api url
    Then I get animal in the response body of the api

  Scenario: Validation of negative response code, Get Animal from the Application as Authenticated User
    Given I am an unauthenticated user
    Then I should get 400 as the response code

  Scenario: Validation of negative response body for Get Animal from the Application as Authenticated User
    Given I hit the get animal api url without access code
    Then I get unauthorized response code of 401 the server

