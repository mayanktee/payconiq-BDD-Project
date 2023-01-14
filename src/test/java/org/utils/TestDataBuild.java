package org.utils;

import requestPojo.BookingDates;
import requestPojo.CreateBooking;

public class TestDataBuild {

    public CreateBooking createBookingPayload(String fname,String lname){

        CreateBooking cb = new CreateBooking();
        BookingDates bd = new BookingDates();

        cb.setFirstname(fname);
        cb.setLastname(lname);
        cb.setTotalprice("111");
        cb.setDepositpaid(true);
        bd.setCheckin("2018-01-01");
        bd.setCheckout("2019-01-01");
        cb.setBookingdates(bd);
        cb.setAdditionalneeds("Breakfast");

        return cb;
        /*return "{   \n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";*/
    }

    public String createBookingPayloadRaw(){


        return "{   \n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
    }

}
