package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ApiStepDefinitions {

    private Response response;
    private int createdResourceId;

    @Given("I set up the base API endpoint")
    public void iSetUpTheBaseApiEndpoint() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("I send a POST request to create a new resource")
    public void iSendAPostRequestToCreateANewResource() {
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{ \"title\": \"Test Title\", \"body\": \"Test Body\", \"userId\": 1 }")
                .post("/posts");

        createdResourceId = response.jsonPath().getInt("id"); // Extract the ID of the created resource
    }

    @Then("I should receive a status code of {int}")
    public void iShouldReceiveAStatusCodeOf(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain the title {string}")
    public void theResponseShouldContainTheTitle(String expectedTitle) {
        response.then().body("title", equalTo(expectedTitle));
    }

    @When("I send a GET request to retrieve the created resource")
    public void iSendAGetRequestToRetrieveTheCreatedResource() {
        response = RestAssured.get("/posts/" + createdResourceId);
    }

    @When("I send a PUT request to update the resource")
    public void iSendAPutRequestToUpdateTheResource() {
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{ \"id\": " + createdResourceId + ", \"title\": \"Updated Title\", \"body\": \"Updated Body\", \"userId\": 1 }")
                .put("/posts/" + createdResourceId);
    }

    @Then("the response should contain the updated title {string}")
    public void theResponseShouldContainTheUpdatedTitle(String expectedUpdatedTitle) {
        response.then().body("title", equalTo(expectedUpdatedTitle));
    }

    @When("I send a DELETE request to delete the resource")
    public void iSendADeleteRequestToDeleteTheResource() {
        response = RestAssured.delete("/posts/" + createdResourceId);
    }
}
