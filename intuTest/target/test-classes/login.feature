Feature:To login as a Registered Customer

  As a costumer
  I want to login
  So that I can explore the intu application

  Background: user on login Page
    Given I am on the login page


  Scenario:To login successfully as a Registerd Customer with valid email and password
    And I want to login as a Registered Customer
    When I enter valid "email address" and valid "password" to login successfully
    Then I should be able to see a success message "Account Dashboard"
    And I see user wished "Hello, G T!" on logged in page
    And I logout
    Then I should be able to see a success message "You are now logged out"


  Scenario Outline: Registered user logins with invalid credentials
    When I enter invalid "<Email Address>", "<Password>" and click login
    Then I should be able to see and error message "Invalid login or password."

    Examples:
      | Email Address     | Password    |
      | tueuf@test.com    | ewujijd1234 |
      | gjhguf@test.com   | hjhgjy45    |
      | fhrgjtrh@test.com | 6565656     |

  @test
  Scenario: Registered Customer Forgot password
    And As Registered Customer I click on the "Forgot Your Password" tab
    Then I should be able to see message "Forgot Your Password?"
    And I re-enter the "email address"
    Then I click submit button
    And  Then I should be able to see message "reset your password"

