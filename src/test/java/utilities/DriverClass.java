package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null) { // If we don't have any  drivers create a new driver for us. But if we already have a driver don't create a new one give us the old one
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        driver = null;
    }
}
