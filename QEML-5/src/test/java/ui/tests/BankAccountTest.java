package ui.tests;

import org.testng.annotations.Test;
import ui.pages.BankAccountPage;

import static utilities.webdriverfactory.DriverManager.getThreadLocalDriver;

public class BankAccountTest extends BaseTest{

    @Test(description = "registering a new bank account by proving the required details")
    public void testBankAccount() throws InterruptedException {

//        BankAccountPage bankAccountPage=new BankAccountPage(getThreadLocalDriver());
        BankAccountPage bankAccountPage=new BankAccountPage();
        logInUser();
        bankAccountPage.clickBankAccount();
        bankAccountPage.registerNewBankAccount();
    }
}
