package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Properties;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static Properties config;

    static {
        config = new Properties();
        try {
            config.load(DriverManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void initializeDriver() {
        String browsers = config.getProperty("browser", "chrome").trim().toLowerCase();
        String[] browserList = browsers.split(", ");

        for (String browser : browserList) {
            WebDriver driver = null;

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--ignore-certificate-errors");
                    driverThreadLocal.set(new ChromeDriver(chromeOptions));
                    configureDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--ignore-certificate-errors");
                    driverThreadLocal.set(new FirefoxDriver(firefoxOptions));
                    configureDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--ignore-certificate-errors");
                    driverThreadLocal.set(new EdgeDriver(edgeOptions));
                    configureDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }

            if (driver != null) {
                driverThreadLocal.set(driver);
                System.out.println("Driver initialized successfully for: " + browser);
            }
        }
    }

    private static void configureDriver() {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}

