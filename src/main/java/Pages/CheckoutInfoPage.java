package Pages;

import Utils.ClickUtil;
import Utils.TextUtil;
import Utils.VisibilityUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {
    WebDriver driver;
    public CheckoutInfoPage(WebDriver driver){this.driver=driver;}

    //Locators
    By checkoutHeader   = By.xpath("//div[text()='Checkout: Your Information']");
    By firstNameInput   = By.id("first-name");
    By lastNameInput    = By.id("last-name");
    By postalCodeInput  = By.id("postal-code");
    By cancelButton     = By.xpath("//a[text()='CANCEL']");
    By continueButton   = By.xpath("//input[@type='submit']");

    //Methods
    public void isCheckoutHeaderVisible(){
        VisibilityUtil.isVisible(driver,checkoutHeader);
    }

    public void enterFirstName(String user){
        TextUtil.enterText(driver,firstNameInput,user);
    }

    public void enterLastName(String user){
        TextUtil.enterText(driver,lastNameInput,user);
    }

    public void enterPostalCode(String code){
        TextUtil.enterText(driver,postalCodeInput,code);
    }

    public void clickCancelButton(){
        ClickUtil.clicking(driver,cancelButton);
    }

    public void clickContinueButton(){
        ClickUtil.clicking(driver,continueButton);
    }

}
