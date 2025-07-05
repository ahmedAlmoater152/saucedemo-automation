package Pages;

import Utils.ClickUtil;
import Utils.VisibilityUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver){this.driver=driver;}

    //Locators
    By checkoutHeader   = By.xpath("//div[text()='Checkout: Overview']");
    By cancelButton     = By.xpath("//a[text()='CANCEL']");
    By FinishButton   = By.xpath("//a[text()='FINISH']");

    //Methods
    public void isCheckoutHeaderVisible(){
        VisibilityUtil.isVisible(driver,checkoutHeader);
    }

    public void clickCancelButton(){
        ClickUtil.clicking(driver,cancelButton);
    }

    public void clickFinishButton(){
        ClickUtil.clicking(driver,FinishButton);
    }
}
