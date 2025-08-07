Feature: Home Page
  As a user
  I want to verify the home page elements
  So that I can ensure the basic functionality works

  @smoke
  Scenario: Verify home page loads successfully
    Given I am on the home page
    Then I should see the home page elements

  @smoke
  Scenario: Navigate to Phones category and select a product
    Given I am on the home page
    When I select the "Phones" category
    And I select the product "SAMSUNG_GALAXY_S6"
    Then I should see Add to Cart button
    And I select the Add to Cart button
    Then I should see "Product added" alert