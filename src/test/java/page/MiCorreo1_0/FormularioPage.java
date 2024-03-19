package page.MiCorreo1_0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.BasePage;

import java.util.LinkedHashMap;
import java.util.Map;


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
    private By pagoTarjeta = By.id("radioTarjeta");
    private By pagoSaldo = By.id("radioSaldo");
    private By pagoCtaCte = By.id("radioCuentaCorriente");

    public FormularioPage(WebDriver driver) {
        super(driver);
    }
    public void validarFormularioEnvios() {
        try {
            scrollToElement(formularioPendientesLocator);
        }catch (Exception e) {
            scrollToElement(formularioPendientesLocator);
        }
        validarCampo("Integración", integracionLocator, getText(integracionLocator));
        validarCampo("Origen", origenLocator, getText(origenLocator));
        validarCampo("Destino", destinoLocator, getText(destinoLocator));
        validarCampo("Admisión", admisionLocator, getText(admisionLocator));
        validarCampo("Entrega", entregaLocator, getText(entregaLocator));
        validarCampo("Peso", pesoLocator, getText(pesoLocator));
        validarCampo("Largo", largoLocator, getText(largoLocator));
        validarCampo("Ancho", anchoLocator, getText(anchoLocator));
        validarCampo("Altura", alturaLocator, getText(alturaLocator));
        validarCampo("Estado", estadoLocator, getText(estadoLocator));
        validarCampo("Comentario", comentarioLocator, getText(comentarioLocator));
        System.out.println("¡Los campos se llenaron correctamente!");

    }
    public void validarFormularioCheckout(){
        validarCampo("Integración", integracionLocator, getText(integracionLocator));
        validarCampo("Origen", origenLocator, getText(origenLocator));
        validarCampo("Destino", destinoLocator, getText(destinoLocator));
        validarCampo("Peso Declarado", pesoDeclaradoLocator,getText(pesoDeclaradoLocator));
        validarCampo("Peso Volumetrico",pesoVolumetricoLocator,getText(pesoVolumetricoLocator));
        validarCampo("Largo",largoCheckoutLocator,getText(largoCheckoutLocator));
        validarCampo("Ancho",anchoCheckoutLocator,getText(anchoCheckoutLocator));
        validarCampo("Altura",alturaCheckoutLocator,getText(alturaCheckoutLocator));
        validarCampo("Precio Unitario", precioUnitarioLocator,getText(precioUnitarioLocator));
        System.out.println("¡Checkout correcto!");
    }

    public void validarFormularioTarjeta(){
        validarCampoExistenteYEditable(By.id("card_number"));
        validarCampoExistenteYEditable(By.id("security_code"));
        validarCampoExistenteYEditable(By.id("card_expiration_month"));
        validarCampoExistenteYEditable(By.id("card_expiration_year"));
        validarCampoExistenteYEditable(By.id("card_holder_name"));
        validarCampoExistenteYEditable(By.id("card_holder_doc_number"));
    }

    public void validarFormularioTarjeta2() {
        // Definir los localizadores de los campos del formulario de tarjetas
        By[] camposTarjeta = {
                By.id("card_number"),
                By.id("security_code"),
                By.id("card_expiration_month"),
                By.id("card_expiration_year"),
                By.id("card_holder_name"),
                By.id("card_holder_doc_number")
        };

        // Verificar cada campo del formulario de tarjetas
        boolean todosPresentesYEditables = true;
        for (By campo : camposTarjeta) {
            boolean resultado = validarCampoExistenteYEditable(campo);
            todosPresentesYEditables &= resultado;
        }

        // Generar un mensaje único indicando si todos los campos están presentes y son editables
        if (todosPresentesYEditables) {
            System.out.println("Todos los campos del formulario de tarjetas están presentes y son editables.");
        } else {
            System.out.println("Algunos campos del formulario de tarjetas no están presentes o no son editables.");
        }
    }


    public void cotizar(){
        /*click(By.xpath("(//div[@class='*checkbox *checkbox-primary'])[1]"));
        waitForSeconds(1);
        clickWithRetry(By.xpath("//button[@id='btnpedido']"));
        waitForSeconds(3);
         */
            try {
                click(By.xpath("(//div[@class='*checkbox *checkbox-primary'])[1]"));
            } catch (Exception e) {
                // Si falla el primer clic, manejar la excepción
                System.out.println("Apareció un cuadro de diálogo. Tratando de aceptarlo...");
                try {
                    click(By.xpath("(//button[@type='button' and @class='btn btn-default' and @data-dismiss='modal'])[2]"));
                } catch (Exception ex) {
                    System.out.println("No se pudo hacer clic en el botón Aceptar.");
                    ex.printStackTrace();
                }

                // Intentar nuevamente el primer clic
                click(By.xpath("(//div[@class='*checkbox *checkbox-primary'])[1]"));
            }

            // Hacer clic en el botón de pedido después del primer clic
            waitForSeconds(1);
            clickWithRetry(By.xpath("//button[@id='btnpedido']"));
            waitForSeconds(3);

    }


    public void verificarMensajeDeExito() {
        // Definir las partes del mensaje de éxito junto con sus localizadores y textos esperados
        Map<By, String> partesMensajeExito = new LinkedHashMap<>();
        partesMensajeExito.put(By.xpath("//h1[@class='page-header']"), "¡Éxito!");
        partesMensajeExito.put(By.xpath("//h2[normalize-space()='Pago procesado correctamente.']"), "Pago procesado correctamente.");
        partesMensajeExito.put(By.xpath("//h4[normalize-space()='El pedido de tus envíos se procesó con éxito.']"), "El pedido de tus envíos se procesó con éxito.");

        // Verificar cada parte del mensaje de éxito
        boolean mensajeCompleto = true;
        for (Map.Entry<By, String> entry : partesMensajeExito.entrySet()) {
            By locator = entry.getKey();
            String textoEsperado = entry.getValue();

            boolean resultado = compararTextoConMensajeEsperado(locator, textoEsperado);
            mensajeCompleto &= resultado;

            if (!resultado) {
                System.out.println("La parte del mensaje no coincide con el texto esperado: " + textoEsperado);
            }
        }

        // Verificar si el mensaje completo coincide con el texto esperado
        if (mensajeCompleto) {
            System.out.println("¡El pago del envio se realizó exitosamente!");
        } else {
            System.out.println("Lamentablemante no se concretó el pago del envio.");
        }
    }

    public void verificarMensajeEsperadoDeExito(String textoEsperado) {
        // Verificar si el texto esperado está presente en toda la página
        boolean mensajeCompleto = verificarTextoEnPagina(textoEsperado);

        // Imprimir el resultado de la verificación
        if (mensajeCompleto) {
            System.out.println("¡El mensaje de éxito '" + textoEsperado + "' está presente en la página!");
        } else {
            System.out.println("El mensaje de éxito '" + textoEsperado + "' no está presente en la página.");
        }
    }
    private boolean verificarTextoEnPagina(String textoEsperado) {
        String textoPagina = findElement(By.tagName("body")).getText();
        return textoPagina.contains(textoEsperado);
    }

    public void mostrarCodigoTNEnvio() {
        // Definir el localizador para obtener el código TN del envío
        By codigoTNLocator = By.xpath("(//td[@class='table-text'])[9]");

        // Obtener el código TN del envío utilizando el localizador
        String codigoTN = getText(codigoTNLocator);

        // Mostrar el código TN por pantalla
        System.out.println("El código TN del envío es: " + codigoTN);
    }

    public void seleccionarMedioPago(String medioPago) {
        switch (medioPago.toLowerCase()) {
            case "tarjeta":
                clickWithRetry(pagoTarjeta);
                break;
            case "cuenta corriente":
                clickWithRetry(pagoCtaCte);
                break;
            case "saldo":
                clickWithRetry(pagoSaldo);
                break;
            default:
                throw new IllegalArgumentException("Medio de pago no válido: " + medioPago);
        }
    }
    public void pagarConTarjeta(){
        clickWithRetry(By.xpath("//button[@class='btn btn-arrow-right btn-arrow-siguiente']"));
        waitForSeconds(2);
        assertURL("https://twsec02.correoargentino.com.ar/MiCorreo/public/spsdecidir/form");
        System.out.println("Estamos en la seccion de datos de la tarjeta");
        validarFormularioTarjeta2();
        clickWithRetry(By.xpath("//label[@title='Visa']"));
        waitForSeconds(1);
        writeText(By.id("card_number"),"4507990000004905");
        waitForSeconds(1);
        writeText(By.id("security_code"),"775");
        waitForSeconds(1);
        writeText(By.id("card_expiration_month"),"08");
        waitForSeconds(1);
        writeText(By.id("card_expiration_year"),"25");
        waitForSeconds(1);
        writeText(By.id("card_holder_name"),"TARJETA VISA");
        waitForSeconds(1);
        writeText(By.id("card_holder_doc_number"),"27859328");
        waitForSeconds(1);
        clickWithRetry(By.xpath("//button[@id='pagar']"));
        waitForSeconds(4);
    }

}
