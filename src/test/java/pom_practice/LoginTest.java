package pom_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.DriverClass;

public class LoginTest extends DriverClass {

    @BeforeMethod
    public void get_url() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test
    @Parameters({"username", "password"})
    public synchronized void login_with_valid_credentials(String username, String password) {

        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
        String url = driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        if (username.equalsIgnoreCase("John Doe") && password.equalsIgnoreCase("ThisIsNotAPassword")) {
            softAssert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/#appointment");
            driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
            WebElement logoutButton = driver.findElement(By.xpath("//a[.='Logout']"));
            logoutButton.click();
        } else {
            softAssert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        }

        softAssert.assertAll();
    }
}

