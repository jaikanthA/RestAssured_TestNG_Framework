package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"stepdefinition"},
        monochrome = true,
        strict = true,
        plugin={"pretty"},
        tags={"@Test1_GET"}
        )

public class TestRunner {

}
