Feature: API Testing ok

  @tag2
  Scenario: GET Method
    Given Api for testing
    When Retrieve correct information
    Then validate positive response code
