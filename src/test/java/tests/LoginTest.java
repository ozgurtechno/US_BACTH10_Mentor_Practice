package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DriverClass;

public class LoginTest extends DriverClass {

    @BeforeMethod
    public void get_url(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test
    @Parameters({"username", "password"})
    public void login_with_valid_credentials(@Optional("Ozgur") String username, @Optional("Arslan") String password){

        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/#appointment");
    }



}
