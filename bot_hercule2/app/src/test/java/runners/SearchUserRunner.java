package runners;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/search_user.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/search_user.html"}
)
public class SearchUserRunner {
}
