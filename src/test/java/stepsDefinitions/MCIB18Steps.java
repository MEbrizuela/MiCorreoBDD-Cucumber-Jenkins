package stepsDefinitions;

import framework.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.junit.Assert.assertTrue;

public class MCIB18Steps {
    private WebDriver driver = DriverManager.getDriver();
    private String baseUrl = DriverManager.config.getProperty("url");

    @Given("un usuario registrado")
    public void unUsuarioRegistrado() {
        // Puedes incluir aquí la lógica para registrar un usuario, si es necesario
        // Para este ejemplo, no se requiere acción específica.
    }
    @And("estoy en la página de inicio de sesión")
    public void estoyEnLaPaginaDeInicioDeSesion() {
        driver.get(baseUrl);
    }

    @When("accedo a la aplicación")
    public void accedoALaAplicacion() {
        WebElement emailInput = DriverManager.getDriver().findElement(By.id("email"));
        WebElement passwordInput = DriverManager.getDriver().findElement(By.id("password"));
        WebElement ingresarButton = DriverManager.getDriver().findElement(By.xpath("//button[normalize-space()='Ingresar']"));

        emailInput.sendKeys("maxitest@yopmail.com");
        passwordInput.sendKeys("123123");
        ingresarButton.click();
    }

    @Then("debería ser redirigido a la página principal")
    public void deberiaSerRedirigidoALaPaginaPrincipal() {
        // Verifica la redirección comparando la URL actual con la URL esperada.
        String expectedUrl = "https://wcpzt.correo.local/MiCorreo/public/pagina_principal"; // Cambia esto según tu URL esperada
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        assertTrue("La redirección a la página principal fue exitosa", actualUrl.contains(expectedUrl));
    }
}