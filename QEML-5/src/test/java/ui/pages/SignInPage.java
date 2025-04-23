package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {
//    public SignInPage(WebDriver driver){
//        super(driver);
//    }
    @FindBy(xpath = "//a[@class='alert-link' and text()='sign in']")
    WebElement signInLink;

    @FindBy(id="username")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(xpath="//button[contains(@class,'btn-primary')]")
    WebElement signInButton;

    @CacheLookup
    @FindBy(xpath="//span[@id='home-logged-message']")
    WebElement successMessage;

    @FindBy(css="div[data-cy='loginError']")
    WebElement loginErrorBanner;

    @FindBy(css="span[jhitranslate='global.menu.home']")
    WebElement homeButton;

    @FindBy(id="account-menu")
    WebElement account_menu;

    @FindBy(id="logout")
    WebElement logout_button;

    public void clickSignIn(String user ,String pass){
        signInLink.click();
        userName.sendKeys(user);
        password.sendKeys(pass);
        signInButton.click();
    }
    public String getConfirmationMessage(){
        return waitTillVisible(successMessage).getText();

    }
    public void navigateBack(){
        waitTillClick(homeButton);
    }
    public void clickLogOut(){
        waitTillClick(account_menu);
        waitTillClick(logout_button);

    }
    public boolean isLoginSuccessfull(){
       return waitTillVisible(successMessage).isDisplayed();
    }


}
