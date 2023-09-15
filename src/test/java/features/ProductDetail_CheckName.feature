@Regression
Feature: Product Detail Feature

  @Smoke
  Scenario: Check First Product Name of Best Sellers

    Given I click Discover Pasaj Button
    Then I should see Pasaj Page
    When I scroll down until First Product Name of Best Sellers visible
    When I get Product Name in Pasaj Screen
    Then I click First Product of Best Sellers
    Then I scroll up until Name of Product visible
    Then I compare Product Name between Pasaj Screen and First Product of Best Sellers Product Screen