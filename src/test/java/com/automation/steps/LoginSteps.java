package com.automation.steps;

import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboard;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("user is on login page")
    public void userOnLoginPage() {
        loginPage.goTo();
    }

    @When("user enters username {string} and password {string}")
    public void userEntersCredentials(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @When("clicks login button")
    public void clicksLogin() {
        loginPage.clickLogin();
    }

    @Then("user should see dashboard")
    public void verifyDashboard() {
        assertTrue(dashboard.isLoaded(), "Dashboard did not load");
    }

    @When("user logs out")
    public void userLogsOut() {
        dashboard.clickLogout();
    }

    @Then("user should be redirected to login page")
    public void verifyRedirectToLogin() {
        assertEquals(driver.getTitle(), "Login - Example");
    }

    @Then("error message {string} is displayed")
    public void verifyErrorMessage(String expected) {
        assertEquals(loginPage.getErrorMessage(), expected);
    }
}
