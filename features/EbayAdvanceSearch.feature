Feature: Scenario For Advanced Search Page

  @Smoke
  Scenario: Advance Search on Item .
    Given I am on Ebay Advanced Search Page
    When I advanced search on item
      | KeyWord   | Exclude     | Min | Max  |
      | iphone 14 | refurbished | 300 | 9000 |
    Then Verify Search Result for Advanced Search
