package ui.tests;

import junit.framework.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.dataproviders.DataProviders;
import ui.listeners.ListenerImplementationClass;
import ui.pages.RegistrationPage;
import utilities.ExtentReportUtils;
import utilities.webdriverfactory.DriverManager;

@Listeners(ExtentReportUtils.class)
public class RegistrationTest extends BaseTest{

    @Test(description = "new user should be able to register by providing all the info requird"
            , dataProvider = "registrationData"
            ,dataProviderClass = DataProviders.class)
    public void testRegistration(String user,String emails,String pass,String confirm){
//        RegistrationPage registrationPage=new RegistrationPage(driver);
        RegistrationPage registrationPage=new RegistrationPage();
        registrationPage.clickRegistrationLink(user, emails, pass, confirm);
        String actual=registrationPage.getConfirmationMessage();
        Assert.assertEquals("Registration saved!",actual);
        registrationPage.navigateBack();
    }
}
