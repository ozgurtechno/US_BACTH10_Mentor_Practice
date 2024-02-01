package cucumber.stepDefinitions;

import cucumber.pom.LoginPage;
import io.cucumber.java.en.And;
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

    @And("username {string} and password {string}")
    public void usernameAndPassword(String username, String password) {
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
        if (DriverClass.getDriver().getCurrentUrl() == url){
            Assert.assertEquals(url, "https://katalon-demo-cura.herokuapp.com/#appointment");
        }//else{
//            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
//        }


    }

    @And("{string} and {string}")
    public void and(String username, String password) {
        loginPage.makeAppointment.click();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @Then("User should get error")
    public void userShouldGetError() {
        loginPage.errorMessage.isDisplayed();
    }
}
