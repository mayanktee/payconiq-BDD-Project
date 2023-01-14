package org.utils;

public enum APIResources {

    AUTH("/auth"),
    GETBOOKINGID("/booking"),
    GETBOOKING("/booking/{bookingid}"),
    CREATEBOOKING("/booking"),
    UPDATEBOOKING("/booking/"),
    PARTIALUPDATEBOOKING("/booking/"),
    DELETEBOOKING("/booking/{bookingid}");

    private String resource;

    APIResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
