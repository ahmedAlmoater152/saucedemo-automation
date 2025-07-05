package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VisibilityUtil {
    private static WebDriver driver;

    public static void isVisible(WebDriver driver, By locator){
        WaitUtil.wait.until(f->{
            driver.findElement(locator).isDisplayed();
            return true;
        });
    }

    public static boolean boolIsVisible(WebDriver driver, By locator) {
        try {
            WaitUtil.wait.until(f -> driver.findElement(locator).isDisplayed());
            return true;  // visible
        } catch (Exception e) {
            return false; // not visible or timeout
        }
    }

}
