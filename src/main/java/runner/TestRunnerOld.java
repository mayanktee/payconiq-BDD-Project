package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles/deleteBooking.feature"},
        glue = {"step.definitions"},
        monochrome = true,
        dryRun = false,
        tags = "@deleteBooking1",
        plugin = {
                "json:target/jsonReports/cucumber-report.json",
                "rerun:build/cucumber-reports/rerun.txt"
        })
public class TestRunnerOld {
}
