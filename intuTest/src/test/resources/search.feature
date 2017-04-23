Feature: Search in filter options

  As a user
  I want to search products
  So that I can navigate to specific page directly

  @test
  Scenario: Search for brand using filter
    Given I am on landing page which shows "Women's Online Shopping"
    And I view the products from brand named "Sea Ny"
    And I click filter option "Brand"
    When I search for brand named "Sea Ny"
    Then I should see brand named "Sea Ny" in search list


  #Try this below scenario and run. This will pass as below mentioned Brand name Forever21 appears on search list
  #Please tag below scenario as @test and remove the @test from above scenario

  Scenario: Search for brand using filter
    Given I am on landing page which shows "Women's Online Shopping"
    And I view the products from brand named "Forever21"
    And I click filter option "Brand"
    When I search for brand named "Forever21"
    Then I should see brand named "Forever21" in search list