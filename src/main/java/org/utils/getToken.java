package org.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestPojo.UserLogin;


import java.io.IOException;

import static io.restassured.RestAssured.*;

public class getToken {


    public static String getAuthToken() throws IOException {

        RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(Utils.getGlobalValues("baseUrl")).setContentType(ContentType.JSON).build();

        UserLogin login = new UserLogin();
        login.setUsername("admin");
        login.setPassword("password123");

        RequestSpecification reqSpecLogin =  given().spec(reqSpec).body(login);

       Response response = reqSpecLogin.when().post(Utils.getGlobalValues("authResource")).then().extract().response();

       return Utils.getJsonPath(response,"token");

    }
}

