package stepsDefinitions;

import framework.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.MiCorreo1_5.*;

public class NuevoEnvioSteps {
    private WebDriver driver = DriverManager.getDriver();
    private String baseUrl = DriverManager.config.getProperty("url");
    private PageHomeLogin pageHomeLogin = new PageHomeLogin(driver);
    private PageMessageHome pageMessageHome = new PageMessageHome(driver);
    private PageNuevoEnvio pageNuevoEnvio = new PageNuevoEnvio(driver);
    private PageCheckOut pageCheckOut = new PageCheckOut(driver);
    private PageForm pageForm = new PageForm(driver);
    private PagePayment pagePayment = new PagePayment(driver);

    @Given("el usuario está logueado y en la page home")
    public void elUsuarioEstáLogueadoYEnLaPageHome() {
        driver.get(baseUrl);
        pageHomeLogin.login();
    }
    @When("ingresa en nuevo envío individual")
    public void ingresaEnNuevoEnvíoIndividual() {
        pageMessageHome.ingresarANuevoEnvio();
    }
    @And("llena los campos de origen destino y paquete")
    public void llenaLosCamposDeOrigenDestinoYPaquete() {
        // Write code here that turns the phrase above into concrete actions
        pageNuevoEnvio.caracteristicasDelPaquete();
        pageNuevoEnvio.domicilio();
        pageNuevoEnvio.expreso();
    }

    @And("presiona en pagar")
    public void presionaEnAgregarEnvío() {
        pageNuevoEnvio.preionarPagar1();
    }
    @And("se muestra la grilla de checkout")
    public void seMuestraLaGrillaDeCheckout() {
        pageCheckOut.validarFormularioCheckout();
    }
    @Then("realiza el pago del envío")
    public void realizaElPagoDelEnvío() {
        pageCheckOut.presionarPagar();
        pageForm.pagoConTarjeta();
    }
    @Then("se confirma que el pago se ha realizado con éxito")
    public void seConfirmaQueElPagoSeHaRealizadoConÉxito() {
        pagePayment.verificarPago();
    }


}
