package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",  monochrome
        = true,
        plugin = {      "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber/cucumber-report.json",
                "junit:target/cucumber.xml"},
        glue = {"stepDefinition"},
        tags="@Products1 or @Animal")

public class TestRunner {
}
