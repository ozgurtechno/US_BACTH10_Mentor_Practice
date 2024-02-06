package cucumber.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/cucumber/features",
        glue = "cucumber/stepDefinitions",
        tags = "SmokeTest"
)

public class runnerClass extends AbstractTestNGCucumberTests {
}
