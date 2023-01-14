package step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.utils.*;
import requestPojo.CreateBooking;

import java.io.IOException;

public class MyStepdefs {

    private RequestSpecification requestSpec;

    APIResources apiResource;
    private Response response;
    TestDataBuild data = new TestDataBuild();
    public static int booking_id;
    CreateBooking cb=new CreateBooking();
    SessionFilter sessionFilter = new SessionFilter();

    // Request without params
    @Given("User is providing the mandatory request")
    public void userIsProvidingTheMandatoryRequest() throws IOException {
        requestSpec =given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter);

    }
    // Request with params and body
    @Given("User is providing the {string} request  with {string}")
    public void userIsProvidingTheRequestWith(String method, String params) throws IOException{
        if(method.equalsIgnoreCase("Get")) {
            requestSpec = given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter).queryParams(Utils.getAllRequestParams(params));
        }
        else if(method.equalsIgnoreCase("Post")){
            requestSpec = given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter).body(data.createBookingPayloadRaw()).queryParams(Utils.getAllRequestParams(params));
        }
        else if(method.equalsIgnoreCase("Delete")){
            requestSpec = given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter).filter(sessionFilter).pathParam("bookingid",booking_id).header("Cookie","token="+ getToken.getAuthToken());
            System.out.println("Delete Booking Started : ");
        }

    }

    // Request with dynamic first & last name from POJO
    @Given("User is providing the mandatory request with value {string}{string}")
    public void userIsProvidingTheMandatoryRequestWithValue(String fname, String lname) throws IOException {

        requestSpec =given().spec(SpecBuilder.requestSpecification())
                .body(data.createBookingPayload(fname,lname)).filter(sessionFilter);
    }

    @When("User submits {string} API with {string} http request")
    public void userSubmitsAPIWithHttpRequest(String resource, String method) {

         apiResource =  APIResources.valueOf(resource); // ENUM CAPTURED FROM API RESOURCE

        if(method.equalsIgnoreCase("Get") ) {
            System.out.println("Ye wala");
            response = requestSpec.when().get("/booking/{id}");
        }
        else if(method.equalsIgnoreCase("Post")){
            response = requestSpec.when().post(apiResource.getResource());
        }
        else if(method.equalsIgnoreCase("Delete")){
            response = requestSpec.when().delete(apiResource.getResource());
        }

    }

    // False Validation Scenario
    @When("User submits {string} API with {string} http request with False Details")
    public void userSubmitsAPIWithHttpRequestWithFalseDetails(String resource, String method) throws IOException {
        apiResource =  APIResources.valueOf(resource); // ENUM CAPTURED FROM API RESOURCE

        if(method.equalsIgnoreCase("Get")) {
            response = requestSpec.when().get(apiResource.getResource()+Utils.getGlobalValues("falseValue")); // Here false resource is added in code
        }
        else if(method.equalsIgnoreCase("Post")){
            response = requestSpec.when().post(apiResource.getResource()+Utils.getGlobalValues("falseValue"));
        }
    }

    // Validation of status codes
    @Then("Verifying status code {string} in response body")
    public void verifyingStatusCodeInResponseBody(String statusCode) {

        System.out.println("Step3");
        response.then().extract().response();
        String statusCodeActual= String.valueOf(response.statusCode());
        Assert.assertEquals(statusCode,statusCodeActual);

        System.out.println("GET RESPONSE");
    }


    // Getting single booking ID
    @And("User is able to create the booking ID")
    public void userIsAbleToCreateTheBookingID() {
        response.then().extract().response();
        booking_id=Integer.parseInt(Utils.getJsonPath(response,"bookingid"));
        System.out.println(booking_id);
    }

    // Getting all booking Id without Filters
    @And("User is able to get the all booking ID")
    public void userIsAbleToGetTheAllBookingID() {
        response.then().extract().response();
        booking_id=Integer.parseInt(Utils.getJsonPath(response,"bookingid"));
        System.out.println(booking_id);
    }

    @And("User is able to create the booking for {string} {string}")
    public void userIsAbleToCreateTheBookingFor(String fname, String lname) {
        response.then().extract().response();
        String fnameActual=Utils.getJsonPath(response,"booking.firstname");
        String lnameActual=Utils.getJsonPath(response,"booking.lastname");
        Assert.assertEquals(fnameActual,fname,"The request for fist name given matches the first name in response");
        Assert.assertEquals(lnameActual,lname,"The request for last name given matches the last name in response");
    }


    @Then("User is able to delete the booking with API response {string}")
    public void userIsAbleToDeleteTheBookingWithAPIResponse(String statusCode) {
        response.then().extract().response();
        String statusCodeActual= String.valueOf(response.statusCode());
        Assert.assertEquals(statusCode,statusCodeActual);
    }

    // Request with Path Params
    @Given("User is providing the {string} request  with path {string}")
    public void userIsProvidingTheRequestWithPath(String method, String pathParam) throws IOException {

        requestSpec = given().spec(SpecBuilder.requestSpecification()).filter(sessionFilter).pathParam("id",booking_id);

    }

    @And("User is able to retrieve the newly created booking details")
    public void userIsAbleToRetrieveTheNewlyCreatedBookingDetails() {

        cb  = response.then().extract().response().as(CreateBooking.class);

        String fname= cb.getFirstname();
        System.out.println(fname);

    }

    @And("User is able to get the single booking ID")
    public void userIsAbleToGetTheSingleBookingID() {
        response.then().extract().response();
        booking_id=Integer.parseInt(Utils.getJsonPath(response,"bookingid[0]"));
        System.out.println(booking_id);
    }
}
