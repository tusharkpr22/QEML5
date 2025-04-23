package utilities.webdriverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory implements WebDriverFactory{
    private WebDriver driver;
    public WebDriver createDriver(){
         driver=new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized");
        return driver;
    }
}
