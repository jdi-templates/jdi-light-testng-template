package org.mytests.tests.example;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.mytests.tests.TestsInit;

import java.util.Date;

import static io.restassured.RestAssured.*;

public class RestAssuredTests extends TestsInit {

    @Test
    public void RestAssuredSmartGetTest(){
        given()
                .get("http://restcountries.eu/rest/v1/name/russia")
                .then()
                .body("[0].capital", Matchers.equalTo("Moscow"));
    }

    @Test
    public void RestAssuredRudePostTest() {
        String someRandomString = String.format("%1$TH%1$TM%1$TS", new Date());

        JSONObject requestBody = new JSONObject();
        requestBody.put("FirstName", someRandomString);
        requestBody.put("LastName", someRandomString);
        requestBody.put("UserName", someRandomString);
        requestBody.put("Password", someRandomString);
        requestBody.put("Email", someRandomString + "@gmail.com");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("http://restapi.demoqa.com/customer/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void RestAssuredSmartPostTest() {
        RestAssured.baseURI = "http://restapi.demoqa.com";

        String someRandomString = String.format("%1$TH%1$TM%1$TS", new Date());

        JSONObject requestBody = new JSONObject();
        requestBody.put("FirstName", someRandomString);
        requestBody.put("LastName", someRandomString);
        requestBody.put("UserName", someRandomString);
        requestBody.put("Password", someRandomString);
        requestBody.put("Email", someRandomString + "@gmail.com");

        given().urlEncodingEnabled(true)
                .body(requestBody.toString())
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/customer/register")
                .then().statusCode(201);
    }

}
