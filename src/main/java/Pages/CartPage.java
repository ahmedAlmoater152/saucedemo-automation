package Pages;

import Utils.ClickUtil;
import Utils.VisibilityUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver){this.driver=driver;}


    //Locators
    By cartHeader               = By.xpath("//div[text()='Your Cart']");
    By continueShoppingButton   = By.xpath("//a[text()='Continue Shopping']");
    By checkoutButton           = By.xpath("//a[text()='CHECKOUT']");

    private By removeProductButtonByProductIndex(int productIndex){
        return By.xpath("(//div[@class='cart_item'])["+productIndex+"]//button");
    }

    private By productName(int productIndex){
        return By.xpath("(//div[@class='cart_item'])["+productIndex+"]//div[@class='inventory_item_name']");
    }

    private By productPrice(int productIndex){
        return By.xpath("(//div[@class='cart_item'])["+productIndex+"]//div[@class='inventory_item_price']");
    }



    //Methods

    public void isCartHeaderVisible(){
        VisibilityUtil.isVisible(driver,cartHeader);
    }

    public void removeProduct(int index){
        ClickUtil.clicking(driver,removeProductButtonByProductIndex(index));
    }

    public String getProductName(int productIndex){
        WebElement product = driver.findElement(productName(productIndex));
        return product.getText();
    }

    public String getProductPrice(int productIndex){
        WebElement product = driver.findElement(productPrice(productIndex));
        return product.getText();
    }

    public void clickContinueShopping(){
        ClickUtil.clicking(driver,continueShoppingButton);
    }

    public void clickCheckout(){
        ClickUtil.clicking(driver,checkoutButton);
    }

}
