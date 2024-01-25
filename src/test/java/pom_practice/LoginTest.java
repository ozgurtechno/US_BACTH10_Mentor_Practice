package pom_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.DriverClass;

public class LoginTest extends DriverClass {
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void get_url() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test
    @Parameters({"username", "password"})
    public synchronized void login_with_valid_credentials(@Optional("John Doe") String username, @Optional("ThisIsNotAPassword") String password) {
        loginPage.makeAppointment.click();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        String url = driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        if (username.equalsIgnoreCase("John Doe") && password.equalsIgnoreCase("ThisIsNotAPassword")) {
            softAssert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/#appointment");
            loginPage.hamburgerButton.click();
            loginPage.logOut.click();
        } else {
            softAssert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        }

        softAssert.assertAll();
    }
}

