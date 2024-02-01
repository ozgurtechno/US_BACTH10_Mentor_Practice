package cucumber.stepDefinitions;

import cucumber.pom.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.DriverClass;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("Navigate to Katalon Web Site")
    public void navigate_to_katalon_web_site() {
        DriverClass.getDriver().get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Given("Enter {string} and {string}")
    public void enter_and(String username, String password) {
        loginPage.makeAppointment.click();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @When("Click on Login Button")
    public void click_on_login_button() {
        loginPage.loginButton.click();
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
        String url = DriverClass.getDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/#appointment");
    }

    @Then("User should get error")
    public void userShouldGetError() {
        String message = DriverClass.getDriver().findElement(By.xpath("//p[@class='lead text-danger']")).getText();
        Assert.assertEquals(message, "Login failed! Please ensure the username and password are valid.");
    }
}
