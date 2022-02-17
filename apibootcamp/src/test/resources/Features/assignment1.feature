Feature: API Testing

  @tag1 #assertion
  Scenario: POST Method
    Given API for testing
    When posted with correct information
    Then validate positive response code received