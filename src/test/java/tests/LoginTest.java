package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.DriverClass;

public class LoginTest extends DriverClass {

    @BeforeMethod
    public void get_url(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test(dataProvider = "dataProvider")
    public void login_with_valid_credentials(String username, String password){

        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
        String url = driver.getCurrentUrl();
        if (username.equalsIgnoreCase("John Doe") && password.equalsIgnoreCase("ThisIsNotAPassword")){
            Assert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/#appointment");
        } else {
//            Assert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/profile.php#login");
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/profile.php#login");
            softAssert.assertAll();
        }

    }
@DataProvider
    public Object[][] dataProvider(){
        Object[][] provider = {
                {"John doe"},{"ThisIsNotAPassword"},
                {"John doe"},{"ThisIsNotAPassword1234"}

        };
        return provider;
    }
    


}
