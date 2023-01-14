Feature: Validating the Get Hotel Bookings API

  @tc01
  Scenario: Verify user is able to get all the booking IDs with all Mandatory details
    Given User is providing the mandatory request
    When User submits "GETBOOKINGID" API with "Get" http request
    Then Verifying status code "200" in response body
    And User is able to get the all booking ID

  @tc01
  Scenario: Verify user is able to get single booking IDs
    Given User is providing the mandatory request
    When User submits "GETBOOKINGID" API with "Get" http request
    Then Verifying status code "200" in response body
    And User is able to get the single booking ID

  @tc02
  Scenario: Verify user is getting bad response when passing incorrect request
    Given User is providing the mandatory request
    When  User submits "GETBOOKINGID" API with "Get" http request with False Details
    Then Verifying status code "404" in response body


  @tc03
  Scenario: Verify user is able to get the booking IDs with all Optional details
    Given User is providing the "Get" request  with "params"
    When User submits "GETBOOKINGID" API with "Get" http request
    Then Verifying status code "200" in response body




