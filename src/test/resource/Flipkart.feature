#Author: vinoth.selvam@anywhere.co

@LocusAssignment
Feature: FlipKart Functionality.
  

  @Search
  Scenario: Search the product in Flipkart.
    Given Open Flipkart site
    And Check whether the popup displayed
   	Then Cancel the popup
    When the user search a term shoes
    Then validate the values whether its searched for shoes.
    
    @ApplyFilters
    Scenario: Apply filter and validate
    When the user choose two filter
    Then Validate whether the filteres are selected

  @ProductDetailPage
  Scenario: Process for buy the product
  When the user clicks the first product
  And the user  select the size of the item
  Then check whether the user able to see the Buy Now label
  And clicks the Buy now label
  Then should see the login page.
  
  
  
  
