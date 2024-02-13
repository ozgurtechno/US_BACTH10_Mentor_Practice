package cucumber.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.DriverClass;

@CucumberOptions(
        features = "src/test/java/cucumber/features",
        glue = "cucumber/stepDefinitions",
        tags = "@SmokeTest or @RegressionTest",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
public class runnerClass extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters(value = "browser")
    public void SetUp(@Optional(value = "chrome") String browserName) {
        System.out.println("Test is starting");
        DriverClass.threadBrowserName.set(browserName);

    }
}