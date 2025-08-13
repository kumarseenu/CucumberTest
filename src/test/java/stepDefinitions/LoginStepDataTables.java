package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class LoginStepDataTables {
    WebDriver driver;
    private String username;
    private String password;
    private String expectedResult;

    @Given("I have the following login credentials")
    public void userOnLoginPage(DataTable dataTable) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");    
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Convert the DataTable into a List of Maps
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        // Loop through each row and process the login credentials
        for (Map<String, String> row : rows) {
            username = row.get("username");
            password = row.get("password");
            expectedResult = row.get("expectedResult");

            WebElement userName = driver.findElement(By.id("username"));
            WebElement passWord = driver.findElement(By.id("password"));
            userName.sendKeys(username);
            passWord.sendKeys(password);

        }
    }

    @And("I attempt to login with these credentials")
    public void userClicksLogin() {
        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();
    }

    @Then("the login result should be as expected")
    public void userRedirectedToDashboard() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl --> "+currentUrl);
        if (!currentUrl.contains(expectedResult)) {
            throw new AssertionError("User not redirected to dashboard");
        }
        driver.quit();
    }
}
