package step.definitions;

import io.cucumber.java.Before;

import java.io.IOException;


public class Hooks {

    @Before("@deleteBooking")
    public static void beforeDelete() throws IOException {
        MyStepdefs stepDef = new MyStepdefs();
        if(MyStepdefs.booking_id ==0) {
            stepDef.userIsProvidingTheRequestWith("Post", "params");
            stepDef.userSubmitsAPIWithHttpRequest("CREATEBOOKING", "Post");
            stepDef.userIsAbleToCreateTheBookingID();
        }

    }
}

