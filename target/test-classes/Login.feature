Feature: Login Functionality
  		In order do interner banking
  		As a valid para Bank Customer
  		I want to login successfuly

  Scenario Outline: Login Successful
    Given I am in the login page of the para Bank Appliction
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to Overview page

    Examples: 
      | username     | password   | userFullName |
      | "autotester" | "password" | "John Smith" |
      | "tautester"  | "password" | "John Smith" |
