package com.automation.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private final RequestSpecification request;

    public ApiClient(String baseUri) {
        RestAssured.baseURI = baseUri;
        this.request = RestAssured.given()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json");
    }

    public Response get(String path) {
        return request
            .when().get(path)
            .then().extract().response();
    }

    public Response post(String path, Object body) {
        return request
            .body(body)
            .when().post(path)
            .then().extract().response();
    }

    public Response put(String path, Object body) {
        return request
            .body(body)
            .when().put(path)
            .then().extract().response();
    }

    public Response delete(String path) {
        return request
            .when().delete(path)
            .then().extract().response();
    }
}
