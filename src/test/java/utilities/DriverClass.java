package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class DriverClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    @BeforeClass(alwaysRun = true) // Before Class doesn't work with groups. Because we are not running the class.
    // We are running some tests in the class. To make sure it runs all the time we should add alwaysRun=true
    public void createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
        closePreviousDrivers();
    }

    public void closePreviousDrivers(){
        try {
//            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            Runtime.getRuntime().exec("pkill -f chromedriver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
