package cucumber.stepDefinitions;

import cucumber.pom.BookAppointmentPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.DriverClass;

import java.util.List;
import java.util.Map;

public class BookAppointmentSteps {
BookAppointmentPage bp = new BookAppointmentPage();

    @Given("Fill out the form")
    public void fill_out_the_form(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        Select select = new Select(bp.facilitySelect);
        select.selectByIndex(Integer.parseInt(list.get(0).get("index")));
        bp.program.click();
        bp.visitDate.sendKeys(list.get(0).get("date"));
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
