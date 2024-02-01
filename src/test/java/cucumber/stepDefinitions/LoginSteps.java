package cucumber.stepDefinitions;

import cucumber.pom.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.DriverClass;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("Navigate to Katalon Web Site")
    public void navigate_to_katalon_web_site() {
        DriverClass.getDriver().get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Given("Enter username and password")
    public void enter_username_and_password() {
        loginPage.makeAppointment.click();
        loginPage.username.sendKeys("John Doe");
        loginPage.password.sendKeys("ThisIsNotAPassword");
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
}
