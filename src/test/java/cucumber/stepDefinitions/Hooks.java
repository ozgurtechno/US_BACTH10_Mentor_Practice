package cucumber.stepDefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DriverClass;
import utilities.ExcelUtilities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Hooks {

    LocalDateTime startTime;

    @Before // Runs before every scenario
    public void beforeScenario() {
//        System.out.println("Scenario is started");
        startTime = LocalDateTime.now();
    }

    @After // Runs after every scenario
    public void afterScenario(Scenario scenario) {
//        System.out.println("Scenario is ended");
        if (scenario.isFailed()) {
            final byte[] byteImage = ((TakesScreenshot) (DriverClass.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", scenario.getName());
        }

        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);

// scenario name, scenario id, scenario status, start time, end time, duration
        ExcelUtilities.writeScenarioInfoToExcel(scenario, startTime, endTime, duration);

        DriverClass.quitDriver();
    }

    @BeforeStep // Runs before every step
    public void beforeStep(){
        System.out.println("Step is starting");
    }

    @AfterStep // Runs after every step
    public void afterStep(){
        System.out.println("Step is ended");
    }
}
