package ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ui.pages.SignInPage;
import utilities.ConfigReader;
import utilities.webdriverfactory.DriverManager;

import java.io.IOException;
import java.time.Duration;

import static utilities.webdriverfactory.DriverManager.*;


public class BaseTest {
    protected DriverManager driverManager;
    protected WebDriver driver;//make it static
    private ConfigReader configReader;
    protected WebDriverWait wait;
    @BeforeClass
    @Parameters({"browsers"})
    public void setup(@Optional("edge") String browsers) throws IOException {
//        driverManager = DriverManager.getInstance();
//        configReader=new ConfigReader();
//        driverManager.setDriver(browser);
//        //wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//
//
//        String base_url= configReader.getProperty("base.url");
//        driverManager.getDriver().get(base_url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setThreadLocalDriver(browsers);
        getThreadLocalDriver().get("http://localhost:9000/");
       // wait = new WebDriverWait(getThreadLocalDriver(), Duration.ofSeconds(10));
    }
//@BeforeClass
//    public void setup( ) throws IOException {
//        driverManager = DriverManager.getInstance();
//        configReader=new ConfigReader();
//    String browser=System.getProperty("browser");
//        driver= driverManager.setDriver(browser);
//        driver.manage().window().maximize();
//
//        String base_url= configReader.getProperty("base.url");
//        driver.get(base_url);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
    @AfterClass
    public void cleanup(){
//        if (driverManager != null) {
//            driverManager.cleanDriver();
//        }

        getThreadLocalDriver().quit();
        quitDriverAndRemove();
    }
    public  void logInUser(){
//        SignInPage signInPage=new SignInPage(getThreadLocalDriver());
        SignInPage signInPage=new SignInPage();
        signInPage.clickSignIn("admin","admin");
       // String actual=signInPage.clickSignIn();
    }



}
