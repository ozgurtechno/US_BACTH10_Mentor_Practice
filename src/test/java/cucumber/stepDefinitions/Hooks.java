package cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import utilities.DriverClass;

public class Hooks {

    @Before // Runs before every scenario
    public void beforeScenario(){
        System.out.println("Scenario is started");
    }

    @After // Runs after every scenario
    public void afterScenario(){
        System.out.println("Scenario is ended");
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
