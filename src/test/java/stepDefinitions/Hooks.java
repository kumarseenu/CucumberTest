package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.AfterStep;

public class Hooks {

    @Before(order = 1)
    public void setUp() {
        System.out.println("Before Hook: Setting up the test environment...");
        // Example: Initialize API base URL or start a browser
    }

    @Before("@API")
    public void setUpForApiTests() {
        System.out.println("Before Hook for @API: Specific setup for API tests...");
        // Example: Set API-specific configurations
    }

    @After
    public void tearDown() {
        System.out.println("After Hook: Cleaning up after the scenario...");
        // Example: Close browser or delete test data
    }

    @BeforeStep
    public void beforeEachStep() {
        System.out.println("Before Step Hook: Executing before each step...");
    }

    @AfterStep
    public void afterEachStep() {
        System.out.println("After Step Hook: Executing after each step...");
    }
}
