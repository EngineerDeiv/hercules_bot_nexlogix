package runners;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_area.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/create_area.html"}
)
public class CreateAreaRunner {
}
