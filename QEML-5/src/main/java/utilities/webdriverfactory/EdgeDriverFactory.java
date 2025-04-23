package utilities.webdriverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverFactory implements WebDriverFactory{
    private WebDriver driver;
    public WebDriver createDriver(){
        driver=new EdgeDriver();
       EdgeOptions options=new EdgeOptions();
        options.addArguments("start-maximized");
        return driver;
    }
}
