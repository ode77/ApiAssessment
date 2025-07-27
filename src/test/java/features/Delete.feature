@Products1
Feature: DELETE PRODUCTS USING DELETE API CALL

  Scenario Outline: Validate Delete products Api status code work correctly
    Given I hit the url of Delete products api endpoint
    When I pass the url of delete products in the request with "<ProductNumber>"
    Then I receive response code of 200
    Examples:
      | ProductNumber |
      | 5             |


