package cucumber.stepDefinitions;

import cucumber.pom.BookAppointmentPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.DriverClass;

public class BookAppointmentSteps {
BookAppointmentPage bp = new BookAppointmentPage();

    @Given("Fill out the form")
    public void fill_out_the_form() {
        Select select = new Select(bp.facilitySelect);
        select.selectByIndex(1);
        bp.program.click();
        bp.visitDate.sendKeys("12/05/2023");

    }
    @When("Click on Submit Button")
    public void click_on_submit_button() {
        bp.submitButton.click();
    }
    @Then("Appointment should be completed")
    public void appointment_should_be_completed() {
        Assert.assertTrue(DriverClass.getDriver().getCurrentUrl().contains("summary"));
    }
}
