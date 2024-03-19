package page.MiCorreo1_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.BasePage;

public class PageHomeLogin extends BasePage {

    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By btnLogin = By.xpath("//button[@type=\"submit\" and @onclick=\"ValidacionLogin(event)\"]\n");
    private By miCuentaLocator = By.xpath("//span[normalize-space()='Mi cuenta']");
    private By btnlogOut = By.xpath("//a[@class='dropdown-item']");

    public PageHomeLogin(WebDriver driver) {
        super(driver);
    }
    public void login() {
        boolean loginExitoso = false;
        String expectedUrl = "https://wcpzt.correo.local/MiCorreo/public/message-home";
        int intentos = 0;
        int maxIntentos = 2; // Establece el número máximo de intentos

        while (!loginExitoso && intentos < maxIntentos) {
            try {
                // Paso 2
                writeText(emailLocator, "empctacte_test@yopmail.com");
                writeText(passwordLocator, "123123");
                click(btnLogin);

                // Paso 3
                waitForUrlToBe(expectedUrl, 2);

                // Verificar si la URL es la esperada
                String currentUrl = getCurrentURL(); // Utilizando la función encapsulada
                if (currentUrl.equals(expectedUrl)) {
                    // Si estamos en la página principal, el inicio de sesión es exitoso
                    System.out.println("¡Inicio de sesión exitoso!");
                    System.out.println("Estamos en la página principal (message-home).");
                    return; // Salir del método después de un inicio de sesión exitoso
                } else {
                    // Si no estamos en la página principal, continuar con el siguiente intento
                    System.out.println("Inicio de sesión fallido. No estamos en la página principal.");
                    intentos++;
                }
            } catch (Exception e) {
                // Si se produce una excepción, incrementar el contador de intentos
                intentos++;
                System.out.println("Intento de inicio de sesión #" + intentos + " fallido.");
            }
        }
        System.out.println("Inicio de sesión fallido después de " + maxIntentos + " intentos.");
    }
    public void logout(){
        click(miCuentaLocator);
        waitForSeconds(1);
        clickLastElementInDropdown(btnlogOut);
        waitForSeconds(3);
        System.out.println("Logout Exitoso!");
    }
}
