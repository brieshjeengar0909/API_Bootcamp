 Feature: API Testing
 @tag7
  Scenario: Negative get scenario
  Given API for testing negative get method
  When retrieved incorrect information
  Then Validate negative response code for negative get method
  
  @tag8
  Scenario: Negative Post Scenario
  Given API for testing negative post method
  When posted incorrect information
  Then Validate negative response code for negative post method