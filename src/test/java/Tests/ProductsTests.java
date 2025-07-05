package Tests;

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

public class ProductsTests {
    private WebDriver driver;
    String baseUrl ="https://www.saucedemo.com/v1/index.html";
    LoginPage loginPage;
    ProductsPage productsPage;

    @Epic("Products page")
    @Feature("Sorting products")
    @Test(testName = "Sorting products" )
    public void sortingProductsTest(){
        productsPage.isProductsHeaderVisible();
        productsPage.sortProducts(2);
    }

    @Epic("Products page")
    @Feature("adding products")
    @Test(testName = "adding products" )
    public void addingProductsTest(){
        productsPage.isProductsHeaderVisible();
        productsPage.addProduct(1);
        productsPage.addProduct(2);
    }

    @Epic("Products page")
    @Feature("removing products")
    @Test(testName = "removing products" )
    public void removingProductsTest(){
        productsPage.isProductsHeaderVisible();
        productsPage.addProduct(1);
        productsPage.addProduct(2);
        productsPage.removeProduct(1);
        productsPage.removeProduct(2);
    }



    @BeforeMethod
    public void setUp(){
        driver         = new ChromeDriver();
        loginPage      = new LoginPage(driver);
        productsPage   = new ProductsPage(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        loginPage.isAddedBookNameVisible();
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @AfterMethod
    public void tearDown(){driver.quit();}

}
