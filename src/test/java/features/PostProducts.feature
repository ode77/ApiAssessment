@Products1
Feature: Get all products from the api

  Scenario Outline: Validate post products Api status code work correctly
    Given I hit the url of Post products api endpoint
    When I pass the url of products in the request
    And I pass the request body of product title "<ProductTitle>"
    Then I receive response code of 200
    Examples:
      | ProductTitle |
      | Boot         |

  Scenario Outline: Validate post products Api response body works correctly
    Given I hit the url of Post products api endpoint
    When I pass the url of products in the request
    And I pass the request body of product title "<ProductTitle>"
    Then I receive the response body with id as "<id>"
    Examples:
      | ProductTitle | id |
      | Boot         | 21 |
