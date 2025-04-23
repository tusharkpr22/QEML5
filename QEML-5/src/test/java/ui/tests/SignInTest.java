package ui.tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.dataproviders.DataProviders;
import ui.listeners.ListenerImplementationClass;
import ui.pages.SignInPage;
import utilities.ExtentReportUtils;
import utilities.ScreenShotUtils;
import utilities.webdriverfactory.DriverManager;

import java.time.Duration;
@Listeners(ExtentReportUtils.class)
public class SignInTest extends BaseTest {

    @Test(dataProvider = "loginData",dataProviderClass = DataProviders.class)
    public void testSignIn(String user, String password) {
//        SignInPage signInPage = new SignInPage(driver);
        SignInPage signInPage = new SignInPage();

        signInPage.clickSignIn(user, password);
       // SoftAssert softAssert=new SoftAssert();

        //try
        //Logic waiting //
        //catch
        //Unsuccessful

        try{
            if (signInPage.isLoginSuccessfull()) { //
                String actual = signInPage.getConfirmationMessage();
                Assert.assertEquals(actual, "You are logged in as user \"admin\".");
                signInPage.clickLogOut();

            }
        } catch(TimeoutException e){
            Assert.assertFalse(signInPage.isLoginSuccessfull());
         // signInPage.navigateBack();

        }


    }
}
