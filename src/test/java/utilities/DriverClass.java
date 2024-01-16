package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class DriverClass {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true) // Before Class doesn't work with groups. Because we are not running the class.
    // We are running some tests in the class. To make sure it runs all the time we should add alwaysRun=true
    public void createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement advanceButton = driver.findElement(By.id("details-button"));
        advanceButton.click();

        WebElement proceedLink = driver.findElement(By.id("proceed-link"));
        proceedLink.click();

        login();
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
        closePreviousDrivers();
    }

    public void login(){
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("knightrider@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("MichaelKnight1234");

        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        loginButton.click();
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
