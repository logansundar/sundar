Feature: Add Tariff plan Functionality in the telecom

  Scenario: add tariff plan with the valid data
    Given the user should be in the telecom homepage
    And then user click on add tariff plan button
    When user enter all the details
    And user click on the submit button
    Then user should be able to view the sucess message - congratulation you add tarrif plan
