package stepsDefinitions;

import framework.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.EnviosPage;
import page.FormularioPage;
import page.LoginPage;
import page.MessageHomePage;

public class NuevoEnvioIndividualSteps {
    private WebDriver driver = DriverManager.getDriver();
    private String baseUrl = DriverManager.config.getProperty("url");
    private LoginPage loginPage = new LoginPage(driver);
    private MessageHomePage messageHomePage = new MessageHomePage(driver);
    private EnviosPage enviosPage = new EnviosPage(driver);
    private FormularioPage formularioPage = new FormularioPage(driver);
    @Given("el usuario consumidor final está logueado y en la page home")
    public void login() throws InterruptedException {
        driver.get(baseUrl);
        loginPage.login();
    }

    @When("ingresa en nuevo envío individual")
    public void newPackageSingle() throws InterruptedException {
        messageHomePage.SelectEnvioIndividual();
    }

    @And("llena los campos de origen destino y paquete")
    public void fillHomePackageForms() throws InterruptedException {
        enviosPage.EnvioIndividualDomicilio();
        enviosPage.DatosDelPaquete();
    }
    @And("presiona en agregar envío")
    public void addNewPackage() {
        loginPage.clickWithRetry(By.xpath("//button[@id='btnagregar']"));
    }

    @And("el envío se muestra en la grilla de envíos pendientes")
    public void newPackageAddCheck() {
        formularioPage.validarFormularioEnvios();
    }
    @And("Presina en cotizar")
    public void clickCotizar(){
        formularioPage.clickWithRetry(By.xpath("//label[@for='C_radio']"));
        formularioPage.clickWithRetry(By.xpath("//button[@id='btnpedido']"));
    }
    @And("Se muetra la grilla de checkout")
    public void newPackageAddCheckOut(){
        formularioPage.assertURL("https://twsec02.correoargentino.com.ar/MiCorreo/public/checkout");
        formularioPage.validarFormularioCheckout();
    }
}