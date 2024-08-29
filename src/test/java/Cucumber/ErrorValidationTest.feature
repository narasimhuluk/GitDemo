
@tag
Feature: Title of your feature
  I want to use this template for my feature file

 Background:
 Given I landed on Ecommerce on Page
 
  @ErrorValidation
  Scenario Outline: negative Test of Submiting order
    Given Logged in with username <userName> and password <Password> 
    Then message is displayed
  

    Examples: 
      | userName  | Password |
      |narasimhulu3k@gmail.com|Narasimha@44|
