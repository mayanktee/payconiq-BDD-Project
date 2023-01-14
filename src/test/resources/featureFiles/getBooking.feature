Feature: Validating the Get Hotel Bookings API

  @one23
  Scenario: Verify user is able to get the booking IDs with all Mandatory details
    Given User is providing the "Post" request  with "params"
    When User submits "CREATEBOOKING" API with "Post" http request
    Then Verifying status code "200" in response body
    And User is able to create the booking ID
    Given User is providing the "Get" request  with path "params"
    When User submits "GETBOOKING" API with "Get" http request
    Then Verifying status code "200" in response body
    And User is able to retrieve the newly created booking details


  @one
  Scenario: Verify user is able to get the booking IDs with all Mandatory details
    Given User is providing the "Post" request  with "params"
    When User submits "CREATEBOOKING" API with "Post" http request
    Then Verifying status code "200" in response body
    And User is able to create the booking ID
    Given User is providing the "Get" request  with path "params"
    When User submits "GETBOOKING" API with "Get" http request
    Then Verifying status code "200" in response body
    And User is able to retrieve the newly created booking details


  @tc02
  Scenario: Verify user is getting bad response when passing incorrect request
    Given User is providing the "Get" request  with path "params"
    When  User submits "GETBOOKING" API with "Get" http request with False Details
    Then Verifying status code "404" in response body


  @tc03
  Scenario: Verify user is able to get the booking IDs with all Optional details
    Given User is providing the "Get" request  with path "params"
    When User submits "GETBOOKING" API with "Get" http request
    Then Verifying status code "200" in response body




