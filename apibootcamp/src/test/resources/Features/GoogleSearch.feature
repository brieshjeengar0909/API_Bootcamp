Feature: feature to test google search

  Scenario: validate google search
    Given browser is open
    And usr is on google search page
    When user enters a text in search box
    And hits enter
    Then user is navigated to search results
