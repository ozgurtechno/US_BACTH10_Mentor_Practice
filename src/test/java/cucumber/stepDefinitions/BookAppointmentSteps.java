package cucumber.stepDefinitions;

import io.cucumber.java.en.*;

public class BookAppointmentSteps {

    @Given("Fill out the form")
    public void fill_out_the_form() {
        System.out.println("done");
    }
    @When("Click on Submit Button")
    public void click_on_submit_button() {
        System.out.println("done");
    }
    @Then("Appointment should be completed")
    public void appointment_should_be_completed() {
        System.out.println("done");
    }
}
