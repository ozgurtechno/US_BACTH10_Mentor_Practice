package cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;

public class pagesForLogin {
    public pagesForLogin() {
        PageFactory.initElements(DriverClass.getDriver(),this);
    }
    @FindBy(id = "btn-make-appointment")
    public WebElement makeAppointment;

    @FindBy(id = "txt-username")
    public WebElement username;
    @FindBy(id = "txt-password")
    public WebElement password;

    @FindBy(id = "btn-login")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@id='menu-toggle']")
    public WebElement hamburgerButton;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logOut;

}
