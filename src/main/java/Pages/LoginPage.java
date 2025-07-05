package Pages;

import Utils.ClickUtil;
import Utils.TextUtil;
import Utils.VisibilityUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){this.driver=driver;}

    //Locators
    By logo          = By.className("login_logo");
    By userName      = By.id("user-name");
    By password      = By.id("password");
    By loginButton   = By.id("login-button");

    //Methods

    public void isAddedBookNameVisible(){
        VisibilityUtil.isVisible(driver,logo);
    }

    public void enterUserName(String user){
        TextUtil.enterText(driver,userName,user);
    }

    public void enterPassword(String pass){
        TextUtil.enterText(driver,password,pass);
    }

    public void clickLogin(){
        ClickUtil.clicking(driver,loginButton);
    }


}
