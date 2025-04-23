package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BankAccountPage extends  BasePage{
//    public BankAccountPage(WebDriver driver){
//        super(driver);
//    }
    @FindBy(id="entity-menu")
    WebElement entityMenu;

    @FindBy(xpath="//a[@class='dropdown-item']//span[text()='Bank Account']")
    WebElement bankAccountLink;

    @FindBy(id="jh-create-entity")
    WebElement createBankAccountButton;

    @FindBy(css="input#field_name")
    WebElement name;

    @FindBy(css="input#field_balance")
    WebElement balance;

    @FindBy(css="select#field_user")
    WebElement userDropdownButton;

    @FindBy(id="save-entity")
    WebElement saveButton;

    public void clickBankAccount() throws InterruptedException {
        waitTillClick(entityMenu);
        waitTillClick(bankAccountLink);
        waitTillClick(createBankAccountButton);

//        waitTillVisible(entityMenu).click();
//        waitTillVisible(bankAccountLink).click();
//        waitTillVisible(createBankAccountButton).click();
    }
    public void registerNewBankAccount(){
        waitTillVisible(name).sendKeys("xyz");
        waitTillVisible(balance).sendKeys("1000");
        waitTillClick(userDropdownButton);
        Select select=new Select(waitTillVisible(userDropdownButton));
        select.selectByValue("2: Object");
        waitTillClick(saveButton);

    }
}
