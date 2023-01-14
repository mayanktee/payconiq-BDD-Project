package cucumber.Options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles/deleteBooking.feature"},
        glue = {"step.definitions"},
        monochrome = true,
        tags = "@deleteBooking",
        plugin = {
                "json:target/jsonReports/cucumber-report.json",
                "html:target/cucumber-reports",
                "pretty"
        })
public class TestRunner {
}
