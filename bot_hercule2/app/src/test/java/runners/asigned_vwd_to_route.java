package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/asign_vehicule_driver_for_routers_and_check.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class asigned_vwd_to_route {
}
