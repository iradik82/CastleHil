Feature: Login Functionality /
         As a Swag Labs customer who is not locked out, I need to be able to log in so
         that I can purchase Sauce Labs merch.

  Background: navigate to Sauce Demo Login Page
    Given I am on the Sauce Demo Login Page

  @smoke @LoginPass
  Scenario: Successful Login

    When I fill the account information for account StandardUser into the Username field "standard_user" and the Password field "secret_sauce"
    And I click the Login Button
    Then I am redirected to the Sauce Demo Main Page
    And I verify the App Logo exists

    @smoke @LoginFailed
  Scenario: Failed Login

    When I fill the account information for account LockedOutUser into the Username field "locked_out_user" and the Password field "secret_sauce"
    And I click the Login Button
    Then I verify the Error Message contains the text "Sorry, this user has been banned"