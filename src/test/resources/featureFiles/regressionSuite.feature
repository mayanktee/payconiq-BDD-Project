Feature: Validating all the Hotel Bookings API in single run

  @create
  Scenario: Verify user is able to create the booking
    Given User is providing the "Post" request  with "params"
    When User submits "CREATEBOOKING" API with "Post" http request
    Then Verifying status code "200" in response body
    And User is able to create the booking ID

    @get
  Scenario: Verify user is able to get the booking
    Given User is providing the "Get" request  with path "params"
    When User submits "GETBOOKING" API with "Get" http request
    Then Verifying status code "200" in response body
    And User is able to get the single booking ID

  @delete
    Scenario: User is deleting the booking ID
    Given User is providing the "Delete" request  with "params"
    When User submits "DELETEBOOKING" API with "Delete" http request
    Then User is able to delete the booking with API response "201"




