package cucumber.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

public class BookAppointmentPage extends MyMethods {

    public BookAppointmentPage(){
        PageFactory.initElements(DriverClass.getDriver(),this);
    }

    @FindBy(id = "combo_facility")
    public WebElement facilitySelect;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement program;

    @FindBy(id = "txt_visit_date")
    public WebElement visitDate;

    @FindBy(id = "btn-book-appointment")
    public WebElement submitButton;






}
