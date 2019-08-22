Feature: Add Customer Functionality

  Scenario: add customer with valid data
    Given the user should be in telecom homepage
    And then user click on add customer button
    When user enter all details
    And user click on submit button
    Then user should be able to view the customer id
