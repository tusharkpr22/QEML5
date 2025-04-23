package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class    RegistrationPage extends BasePage{
//    public RegistrationPage(WebDriver driver){
//        super(driver);
//    }


    @FindBy(xpath="//a[normalize-space(.)='Register a new account']")
    WebElement registrationLink;
    @FindBy(css = "input#login")
    WebElement username;
    @FindBy(css="input#email")
    WebElement email;
    @FindBy(css="input#password")
    WebElement password;
    @FindBy(css="input#confirmPassword")
    WebElement confirmPassword;
    @FindBy(xpath="//button[normalize-space(.)='Register']")
    WebElement registerButton;
    @FindBy(xpath="//div[contains(@class,'alert-success')]/strong")
    WebElement confirmation;
    @FindBy(css="span[jhitranslate='global.menu.home']")
    WebElement homeButton;

    public void clickRegistrationLink(String user,String emails,String pass,String confirm){
        registrationLink.click();
        username.sendKeys(user);
        email.sendKeys(emails);
        password.sendKeys(pass);
        confirmPassword.sendKeys(confirm);
        registerButton.click();
    }
    public String getConfirmationMessage(){
        return waitTillVisible(confirmation).getText();

    }
    public void navigateBack(){
        waitTillClick(homeButton);
    }
    public boolean isRegistrationSuccessfull(){
        return waitTillVisible(registerButton).isEnabled();
    }



}
