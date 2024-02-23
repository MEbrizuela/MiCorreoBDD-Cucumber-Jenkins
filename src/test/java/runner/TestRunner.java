package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports"},
        stepNotifications = true,
        publish = true,
        features = {"src/main/resources/features"},
        glue = {"stepsDefinitions", "framework"}, // Agrega el paquete de los hooks y framework
        tags =  "@E2E"
)
public class TestRunner {
}

