Feature: New Registration in Parabank


  Scenario: Successful New Registration with valid details
    Given the user is on the New Registration page "https://parabank.parasoft.com/parabank/register.htm;jsessionid=2756C904F39EE515B6B21FFD193BF463"
    When the user enters valid New Registration details
    And the user clicks the Register button
    Then the account should be created successfully "Your account was created successfully. You are now logged in."
    And Logout After successfully Done New Registration
   Then close the browser