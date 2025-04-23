Feature: Flight Search Functionality

  Scenario Outline: Verify flight search from <from> to <to> on a specific date
    Given I open the flight search page
    When I enter "<from>" as the departure city
    And I enter "<to>" as the destination city
    And I select "<date>" as the departure date
    And I click the search button
    Then I should see flights from "<from>" to "<to>" for "<date>"

    Examples:
      | from | to  | date     |
      | DEL  | BOM | today    |
      | DEL  | BOM | tomorrow |

  Scenario Outline: Verify flight search from <from> to <to> on a specific date
    Given I open the flight search page
    When I enter "<from>" as the departure city
    And I enter "<to>" as the destination city
    And I select "<date>" as the departure date
    And I click the search button
    Then I should see flights from "<from>" to "<to>" for "<date>"

    Examples:
      | from | to  | date       |
      | DEL  | BOM | 2025-04-26 |
      | DEL  | BOM | 2025-04-30 |