package Pages;

import Utils.ClickUtil;
import Utils.VisibilityUtil;
import Utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    WebDriver driver;
    public ProductsPage(WebDriver driver){this.driver=driver;}

    //Locators
    By productsHeader       = By.xpath("//div[text()='Products']");
    By shoppingCartIcon     = By.id("shopping_cart_container");
    By sortDropDown         = By.className("product_sort_container");
    By menu                 = By.xpath("//button[text()='Open Menu']");
    By logoutselection      = By.id("logout_sidebar_link");

    private By addProductButtonByProductIndex(int productIndex){
        return By.xpath("(//div[@class='inventory_item'])["+productIndex+"]//button");
    }

    private By removeProductButtonByProductIndex(int productIndex){
        return By.xpath("(//div[@class='inventory_item'])["+productIndex+"]//button");
    }

    private By productName(int productIndex){
        return By.xpath("(//div[@class='inventory_item'])["+productIndex+"]//div[@class='inventory_item_name']");
    }



    //Methods
    public void isProductsHeaderVisible(){
        VisibilityUtil.isVisible(driver,productsHeader);
    }

    public void sortProducts(int index){
        WebElement selectElement = driver.findElement(sortDropDown);
        Select select = new Select(selectElement);
        select.selectByIndex(index);
    }


    public void addProduct(int index){
        ClickUtil.clicking(driver,addProductButtonByProductIndex(index));
    }

    public void removeProduct(int index){
        ClickUtil.clicking(driver,removeProductButtonByProductIndex(index));
    }

    public void clickShoppingCartIcon(){
        ClickUtil.clicking(driver,shoppingCartIcon);
    }

    public String getAddProductName(int productIndex){
        WebElement product = driver.findElement(productName(productIndex));
        return product.getText();
    }

    public void logingOut(){
        ClickUtil.clicking(driver,menu);
        ClickUtil.clicking(driver,logoutselection);
    }

    public void sortProducts(String sortOption){
        WebElement selectElement = driver.findElement(sortDropDown);
        Select select = new Select(selectElement);
        select.selectByVisibleText(sortOption);
    }

}
