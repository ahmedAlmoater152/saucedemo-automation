package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickUtil {
    private static WebDriver driver;

    public static void clicking(WebDriver driver, By locator){
        WaitUtil.wait.until(f ->{
            driver.findElement(locator).click();
            return true;
        } );
    }

    public static void jsClick(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
