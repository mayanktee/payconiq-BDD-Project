Feature: Validating the Create Bookings API

  @tc01
  Scenario Outline: Verify user is able create booking ID with all Mandatory details
    Given User is providing the mandatory request with value "<Fname>""<Lname>"
    When User submits "CREATEBOOKING" API with "Post" http request
    Then Verifying status code "200" in response body
    And User is able to create the booking for "<Fname>" "<Lname>"
    Examples:
    |Fname|Lname|
    |Jim  |Brown|

  @tc02
  Scenario: Verify user is getting bad response when passing incorrect request in Create Bookings API
    Given User is providing the mandatory request with value "john""terry"
    When User submits "CREATEBOOKING" API with "Post" http request with False Details
    Then Verifying status code "404" in response body


  @tc03
  Scenario: Verify user is able to get the booking ID with all Optional details
    Given User is providing the "Post" request  with "params"
    When User submits "CREATEBOOKING" API with "Post" http request
    Then Verifying status code "200" in response body

  @tc04
  Scenario: Verify user is able to get the booking ID
    Given User is providing the "Post" request  with "params"
    When User submits "CREATEBOOKING" API with "Post" http request
    Then Verifying status code "200" in response body
    And User is able to create the booking ID
