package cucumber.Runner;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
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
    public void setUp(@Optional("chrome") String browserName) {
        System.out.println("Test is starting");
        DriverClass.threadBrowserName.set(browserName);
    }


    @AfterClass
    public void terminate() {
        System.out.println("Test is ended");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name")); // Adds the info about operating system
        ExtentService.getInstance().setSystemInfo("Tester Name", System.getProperty("user.name")); // Adds the info of the tester
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone")); // Adds time zone info of the user
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus v 2.0.3");
        ExtentService.getInstance().setSystemInfo("Department Name", "QA");
        ExtentService.getInstance().setSystemInfo("Team Name", "QA Team 1");
    }
}
