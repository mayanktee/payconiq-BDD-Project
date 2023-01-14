Feature: Validating the Delete Bookings API

  @one
  Scenario: Verify user is able to delete the booking
    Given User is providing the "Post" request  with ""
    When User submits "CREATEBOOKING" API with "Post" http request
    Then Verifying status code "200" in response body
    And User is able to create the booking ID

    @deleteBooking
    Scenario: Verify user is able to delete the booking
    Given User is providing the "Delete" request  with "params"
    When User submits "DELETEBOOKING" API with "Delete" http request
    Then User is able to delete the booking with API response "201"




