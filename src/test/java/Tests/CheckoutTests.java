package Tests;

import Pages.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class CheckoutTests {
    private WebDriver driver;
    String baseUrl ="https://www.saucedemo.com/v1/index.html";
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cart;
    CheckoutInfoPage checkoutInfo;
    CheckoutOverviewPage checkoutOverview;


    @Epic("checkout page")
    @Feature("checkout")
    @Test(testName = "fill checkout info" )
    public void fillChechoutInfo(){
        cart.isCartHeaderVisible();
        cart.clickCheckout();
        checkoutInfo.enterFirstName("Samah");
        checkoutInfo.enterLastName("Sameh");
        checkoutInfo.enterPostalCode("12345");
        checkoutInfo.clickContinueButton();
        checkoutOverview.isCheckoutHeaderVisible();
    }


    @Epic("checkout page")
    @Feature("checkout")
    @Test(testName = "cancel checkout" )
    public void cancelCheckout(){
        cart.isCartHeaderVisible();
        cart.clickCheckout();
        checkoutInfo.enterFirstName("Samah");
        checkoutInfo.enterLastName("Sameh");
        checkoutInfo.enterPostalCode("12345");
        checkoutInfo.clickContinueButton();
        checkoutOverview.isCheckoutHeaderVisible();
        checkoutOverview.clickCancelButton();
        productsPage.isProductsHeaderVisible();
    }



    @BeforeMethod
    public void setUp(){
        driver            = new ChromeDriver();
        loginPage         = new LoginPage(driver);
        productsPage      = new ProductsPage(driver);
        cart              = new CartPage(driver);
        checkoutInfo      = new CheckoutInfoPage(driver);
        checkoutOverview  = new CheckoutOverviewPage(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        loginPage.isAddedBookNameVisible();
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productsPage.isProductsHeaderVisible();
        productsPage.addProduct(1);
        productsPage.addProduct(2);
        productsPage.clickShoppingCartIcon();
    }

    @AfterMethod
    public void tearDown(){driver.quit();}

}
