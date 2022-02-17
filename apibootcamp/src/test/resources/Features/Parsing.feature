Feature: API Testing

  @tag6
  Scenario: POST2 Method
    Given API for testing Post register
    When post with correct information
    Then validate positive response code received for successful register
