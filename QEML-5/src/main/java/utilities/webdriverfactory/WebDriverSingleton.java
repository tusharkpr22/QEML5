package utilities.webdriverfactory;

import customexceptions.InvalidBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverSingleton{
    private static volatile WebDriverSingleton instance;
    private static WebDriver driver;
    private WebDriverSingleton(){}

    public static WebDriverSingleton getInstance(){
        if(instance==null){
            synchronized (WebDriverSingleton.class){
                if(instance==null){
                    instance=new WebDriverSingleton();
                }
            }
        }
        return instance;
    }

    public  WebDriver getDriver(String browser){
        if(driver==null){
            driver=initializeDriver(browser);
        }
        return driver;
    }
    public static WebDriver initializeDriver(String browser){
        return switch(browser.toLowerCase()){
            case "chrome" ->driver=new ChromeDriver();
            case "edge" -> driver=new EdgeDriver();
            default->throw new InvalidBrowserException("invalid browser");
        };
    }






}
