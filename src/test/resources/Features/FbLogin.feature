Feature: Title of your feature

  Scenario: Title of your scenario
    Given user should be in FB login page
    When user enter the username
    And user enter the password
    And user select login button
    Then user should get an error message
    And user should be directed to FB login page

    Scenario: Login with 1-D List Data
    Given user should be in FB login page
    When user enter valid username
    |sundar|
    And user enter invalid password
    |@123|
    And user select login button
    Then user should get an error message
    And user should be directed to FB login page
    
     Scenario: Login with 1-D Map Data
    Given user should be in FB login page
    When user enter an valid username
    |uname|vel|
    And user enter an invalid password
    |pass|@123|
    And user select login button
    Then user should get an error message
    And user should be directed to FB login page
    
    Scenario Outline: FB Login validation
    Given user should be in FB login page
    When user enter an invalid username and password <"userName">,<"password">
    And user select login button
    Then user should get an error message
    And user should be directed to FB login page 
    
    Examples:
    |userName|password|
    |sun|@123|
    |vel|@8999|
    |java|@7676|
    |logan|@766767|