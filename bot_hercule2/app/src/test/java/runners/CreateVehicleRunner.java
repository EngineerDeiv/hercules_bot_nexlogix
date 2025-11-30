package runners;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/SuiteRutas/Vehiculos/crear.feature",
        glue = {"stepdefinitions","stepdefinitions.rutas.vehiculos"},
        plugin = {"pretty", "html:target/cucumber-reports/create_vehicle.html"}
)
public class CreateVehicleRunner {
}
