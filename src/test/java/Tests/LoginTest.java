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

public class LoginTest {
    private WebDriver driver;
    String baseUrl ="https://www.saucedemo.com/v1/index.html";
    LoginPage loginPage;
    ProductsPage productsPage;

    @Epic("Login")
    @Feature("Valid Login")
    @Test(testName = "valid login with valid password and valid password" )
    public void validLogin(){
        loginPage.isAddedBookNameVisible();
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productsPage.isProductsHeaderVisible();
    }

    @BeforeMethod
    public void setUp(){
        driver         = new ChromeDriver();
        loginPage      = new LoginPage(driver);
        productsPage   = new ProductsPage(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(){driver.quit();}

}
