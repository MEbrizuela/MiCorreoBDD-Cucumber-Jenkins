package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class FormularioPage extends BasePage {
    private By formularioPendientesLocator = By.xpath("(//div[@class='panel-heading'])[4]");
    private By integracionLocator = By.xpath("(//td[@class='table-text'])[1]");
    private By origenLocator = By.xpath("(//td[@class='table-text'])[3]");
    private By destinoLocator = By.xpath("(//td[@class='table-text'])[4]");
    private By admisionLocator = By.xpath("(//td[@class='table-text'])[5]");
    private By entregaLocator = By.xpath("(//td[@class='table-text'])[6]");
    private By pesoLocator = By.xpath("(//td[@class='table-text'])[7]");
    private By largoLocator = By.xpath("(//td[@class='table-text'])[8]");
    private By anchoLocator = By.xpath("(//td[@class='table-text'])[9]");
    private By alturaLocator = By.xpath("(//td[@class='table-text'])[10]");
    private By estadoLocator = By.xpath("(//td[@class='table-text'])[11]");
    private By comentarioLocator = By.xpath("(//td[@class='table-text'])[12]");
    private By pesoDeclaradoLocator = By.xpath("(//td[@class='table-text'])[5]");
    private By pesoVolumetricoLocator = By.xpath("(//td[@class='table-text'])[6]");
    private By largoCheckoutLocator = By.xpath("(//td[@class='table-text'])[7]");
    private By anchoCheckoutLocator = By.xpath("(//td[@class='table-text'])[8]");
    private By alturaCheckoutLocator = By.xpath("(//td[@class='table-text'])[9]");
    private By precioUnitarioLocator = By.xpath("(//td[@class='table-text'])[10]");

    public FormularioPage(WebDriver driver) {
        super(driver);
    }
    public void validarFormularioEnvios() {
        try {
            scrollToElement(formularioPendientesLocator);
        }catch (Exception e) {
            scrollToElement(formularioPendientesLocator);
        }
        validarCampo("Integración", integracionLocator, "MiCorreo");
        validarCampo("Origen", origenLocator, "CAPITAL FEDERAL");
        validarCampo("Destino", destinoLocator, "CORDOBA - Raul Mesa");
        validarCampo("Admisión", admisionLocator, "Sucursal");
        validarCampo("Entrega", entregaLocator, "Domicilio");
        validarCampo("Peso", pesoLocator, "10,000");
        validarCampo("Largo", largoLocator, "25");
        validarCampo("Ancho", anchoLocator, "25");
        validarCampo("Altura", alturaLocator, "30");
        validarCampo("Estado", estadoLocator, "OK");
        validarCampo("Comentario", comentarioLocator, "VALIDADO");
        System.out.println("¡Los campos se llenaron correctamente!");

    }
    public void validarFormularioCheckout(){
        validarCampo("Integración", integracionLocator, "MiCorreo");
        validarCampo("Origen", origenLocator, "CAPITAL FEDERAL");
        validarCampo("Destino", destinoLocator, "CORDOBA - Raul Mesa");
        validarCampo("Peso Declarado", pesoDeclaradoLocator,"10,000");
        validarCampo("Peso Volumetrico",pesoVolumetricoLocator,"3,125");
        validarCampo("Largo",largoCheckoutLocator,"25,000");
        validarCampo("Ancho",anchoCheckoutLocator,"25,000");
        validarCampo("Altura",alturaCheckoutLocator,"30,000");
        validarCampo("Precio Unitario", precioUnitarioLocator,getText(precioUnitarioLocator));
        System.out.println("¡Checkout correcto!");
    }
    private void validarCampo(String nombreCampo, By locator, String textoEsperado) {
        String textoCampo = getText(locator); // Utiliza el método getText() de BasePage para obtener el texto del elemento
        // Verifica si el texto del campo coincide con el texto esperado
        if (textoCampo.equals(textoEsperado)) {
            System.out.println("El campo '" + nombreCampo + "' está correctamente llenado: " + textoCampo);
        } else {
            System.out.println("El campo '" + nombreCampo + "' no coincide con el texto esperado.");
            System.out.println("Texto esperado: " + textoEsperado);
            System.out.println("Texto actual: " + textoCampo);
        }
    }
}
