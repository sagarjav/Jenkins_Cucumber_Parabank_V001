Feature: Login to Parabank

  Scenario: Successful login with valid credentials
    Given the user is on the Parabank login page "https://parabank.parasoft.com/parabank/index.htm"
    When the user enters valid username "sagar124" and password "sagar1234"
    And clicks the login button
    Then the user should be logged in successfully
    And close the browser

  Scenario Outline: Successful login with multiple valid credentials
    Given the user is on the Parabank login page "https://parabank.parasoft.com/parabank/index.htm"
    When the user enters valid username "<user>" and password "<password>"
    And clicks the login button
    Then the user should be logged in successfully
    And close the browser

    Examples:
      | user      | password  |
      | sagar124  | sagar1234 |
      | sagar123  | sagar1234 |
