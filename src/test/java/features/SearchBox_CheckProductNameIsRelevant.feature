@Regression
Feature: Search Result Feature

  @Smoke
  Scenario: Check Product Names is Relevant to Search Text

    Given I click Discover Pasaj Button
    Then I should see Pasaj Page
    When I click SearchBox
    When I fills TextBox
    And I tap Enter on Keyboard
    Then I wait until Search Results loaded
    When I see all Product Names on the Screen
    Then I check Product Names is relevant to Search Text