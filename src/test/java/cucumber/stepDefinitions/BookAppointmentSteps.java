package cucumber.stepDefinitions;

import cucumber.pom.BookAppointmentPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.DriverClass;

public class BookAppointmentSteps {

    BookAppointmentPage bap = new BookAppointmentPage();
    @Given("Fill out the form")
    public void fill_out_the_form() {
        Select select = new Select(bap.facilitySelect);
        select.getFirstSelectedOption();
        bap.program.click();
        bap.visitDate.sendKeys("12/05/2024");

    }
    @When("Click on Submit Button")
    public void click_on_submit_button() {
        bap.submitButton.click();
    }
    @Then("Appointment should be completed")
    public void appointment_should_be_completed() {
        String url = DriverClass.getDriver().getCurrentUrl();
        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary", url);
    }
}
