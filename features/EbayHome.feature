Feature: Ebay Home Page Feature
  
  @Sanity @BeforeHookTag @AfterHookTag 
  Scenario: Verify Ebay Home Page
    Given I am in Ebay Home Page
    Then Verify Page Title

  Scenario: Search For a Product
    Given Ebay Home Page Already Opened
    When Enter Product Name as 'iphone 14 pro max' that need to Search
    Then Verify Search Result

  Scenario: Verify Advance Search Link
    Given Ebay Home Page Opened
    When Click on Advanced Linked
    Then Verify Redirect to Advanced Search Page Open

  Scenario: Search an item in Catagory
    Given Ebay Home Page Opened
    When Search for product 'soap' in 'Baby' category
    Then Verify Search Result for category

  @Regressing
  Scenario Outline: Verify Home Page links
    Given Ebay Home Page Opened
    When Click on Home Page '<link>'
    Then I Verify page '<url>' and page '<title>'

    Examples: 
      | link        | url                                              | title                         |
      | Fashion     | https://www.ebay.com/b/Fashion/bn_7000259856     | Fashion products for sale     |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124 | Electronics products for sale |
