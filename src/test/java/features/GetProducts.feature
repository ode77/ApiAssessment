@Products
Feature: Get all products from the api

  Scenario:
    Given I hit the url of products api endpoint
    When I pass the url of products in the request
    Then I receive response code of 200

  Scenario Outline:
    Given I hit the url of products api endpoint
    When I pass the url of products in the request
    Then I verify that the rate of the first product is "<FirstProduct>"
    Examples:
      | FirstProduct |
    | 3.9     |