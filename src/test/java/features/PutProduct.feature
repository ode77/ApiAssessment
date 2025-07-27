@Products1
Feature: UPDATE PRODUCTS USING PUT API CALL

  Scenario Outline: Validate Put products Api status code work correctly
    Given I hit the url of Put products api endpoint
    When I pass the url of products in the request with "<ProductNumber>"
    Then I receive response code of 200
    Examples:
      | ProductNumber |
      | 5             |


