package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyMethods {

    private WebDriverWait wait = new WebDriverWait(DriverClass.getDriver(), Duration.ofSeconds(15));
    public void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void myClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void mySendKeys(WebElement element, String text){
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void waitForNumberOfElementsToBe(By locator, int number){
        wait.until(ExpectedConditions.numberOfElementsToBe(locator,number));
    }

    public void waitUntilInvisible(List<WebElement> elementList){
        wait.until(ExpectedConditions.invisibilityOfAllElements(elementList));
    }
}
