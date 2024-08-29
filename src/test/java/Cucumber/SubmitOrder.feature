
@tag
Feature: Purchasr the order from Ecommerce Website
  I want to use this template for my feature file


 Background:
 Given I landed on Ecommerce on Page
 

  @Regression
  Scenario Outline: Positive Test of Submiting order
    Given Logged in with username <userName> and password <Password> 
    When I add product <productName> from cart
    And Checkout <productName> and submit the order
    Then "THANKU FOR THE ORDER." message is displayed on the ConfirmationPage

    Examples: 
      | userName  | Password | productName  |
      |narasimhulu3k@gmail.com|Narasimha@444|ZARA COAT 3|
     
