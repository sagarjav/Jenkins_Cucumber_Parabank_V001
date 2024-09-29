package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    public static WebDriver driver;

    // Constructor to initialize the WebDriver
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Method to wait for an element to become visible
    public void waitForElement(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    
    
}
