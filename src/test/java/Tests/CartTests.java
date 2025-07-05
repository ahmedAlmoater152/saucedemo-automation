package Tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class CartTests {
    private WebDriver driver;
    String baseUrl ="https://www.saucedemo.com/v1/index.html";
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cart;


    @Epic("cart page")
    @Feature("cart products")
    @Test(testName = "remove products from cart" )
    public void removeProductsFromCart(){
        productsPage.clickShoppingCartIcon();
        cart.isCartHeaderVisible();
        cart.removeProduct(1);
    }





    @BeforeMethod
    public void setUp(){
        driver         = new ChromeDriver();
        loginPage      = new LoginPage(driver);
        productsPage   = new ProductsPage(driver);
        cart           = new CartPage(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        loginPage.isAddedBookNameVisible();
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productsPage.isProductsHeaderVisible();
        productsPage.addProduct(1);
        productsPage.addProduct(2);
    }

    @AfterMethod
    public void tearDown(){driver.quit();}

}
