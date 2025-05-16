package com.automation.steps;

import com.automation.service.ApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static org.testng.Assert.*;

public class ApiSteps {
    private ApiClient api;
    private Response response;

    @Given("API is available at {string}")
    public void apiIsAvailable(String baseUri) {
        api = new ApiClient(baseUri);
    }

    @When("I send GET request to {string}")
    public void sendGet(String path) {
        response = api.get(path);
    }

    @When("I send POST request to {string} with payload")
    public void sendPost(String path, io.cucumber.datatable.DataTable table) {
        response = api.post(path, table.asMap(String.class, String.class));
    }

    @Then("response status should be {int}")
    public void verifyStatus(int status) {
        assertEquals(response.getStatusCode(), status);
    }

    @Then("response should contain {string}")
    public void verifyBodyContains(String text) {
        assertTrue(response.getBody().asString().contains(text));
    }
}
