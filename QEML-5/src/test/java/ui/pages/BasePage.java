package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.webdriverfactory.DriverManager;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;

    public BasePage() {
//        this.driver = driver;
        this.driver = DriverManager.getThreadLocalDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void waitTillClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public WebElement waitTillVisible(WebElement element){
       return wait.until(ExpectedConditions.visibilityOf(element));
    }
}


