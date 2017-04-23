Feature: Search in filter options

  As a user
  I want to search products
  So that I can navigate to specific page directly

  @test1
  Scenario: Search for brand using filter
    Given I am on landing page which shows "Women's Online Shopping"
    And I view the products from brand named "Sea Ny"
    And I click filter option "Brand"
    When I search for brand named "Sea Ny"
    Then I should see brand named "Sea Ny" in search list
