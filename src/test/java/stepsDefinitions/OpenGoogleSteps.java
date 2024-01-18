package stepsDefinitions;

import framework.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.BasePage;

import static org.junit.Assert.assertTrue;

public class OpenGoogleSteps {

    private WebDriver driver = DriverManager.getDriver();
    private String baseUrl = DriverManager.config.getProperty("url");


    @Given("the user opens the browser")
    public void theUserOpensTheBrowser() {
        // No es necesario inicializar el driver aquí, ya que se realiza en los Hooks
        // DriverManager.initializeDriver();
    }

    @When("the user navigates to Google")
    public void theUserNavigatesToGoogle() {
        driver.get(baseUrl);
    }

    @Then("the user should be on the Google search page")
    public void theUserShouldBeOnTheGoogleSearchPage() {
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Google"));
        BasePage.waitForSeconds(2);
        // No es necesario tomar captura de pantalla aquí, ya que se realiza en los Hooks
        // Hooks.takeScreenShot(true);

        // No es necesario cerrar el driver aquí, ya que se realiza en los Hooks
        // DriverManager.quitDriver();
    }

}

