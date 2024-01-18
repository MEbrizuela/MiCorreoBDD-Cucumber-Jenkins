package framework;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import page.BasePage;

public class Hooks {
    private static WebDriver driver;
    private static Scenario currentScenario;

    @Before
    public void setUp(Scenario scenario) {
        // Inicializar el driver antes de cada escenario
        try {
            // Inicializar el driver antes de cada escenario
            DriverManager.initializeDriver();
            driver = DriverManager.getDriver();
            // Configurar el escenario actual
            currentScenario = scenario;
        } catch (Exception e) {
            System.err.println("Error al inicializar el WebDriver: " + e.getMessage());
            // Puedes agregar lógica adicional aquí, como marcar el escenario como fallido
            // y adjuntar una captura de pantalla si la inicialización del WebDriver falla
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // Tomar captura de pantalla al final del escenario
        takeScreenShot(scenario.isFailed());
        // Cerrar el driver al final de cada escenario solo si no se ha cerrado ya
        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
        }
    }

    public static void takeScreenShot(boolean isFailed) {
        try {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
            if (isFailed) {
                // Adjuntar la captura de pantalla en caso de fallo
                BasePage.waitForSeconds(2);
                currentScenario.attach(screenshot, "image/png", "Captura de pantalla en caso de fallo");
            } else {
                // Adjuntar la captura de pantalla en caso de éxito
                BasePage.waitForSeconds(2);
                currentScenario.attach(screenshot, "image/png", "Captura de pantalla en caso de éxito");
            }
        } catch (Exception e) {
            System.err.println("Error al tomar la captura de pantalla: " + e.getMessage());
        }
    }
}


