package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextUtil {

    public static void enterText(WebDriver driver, By locator, String text){
        WaitUtil.wait.until(f->{
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }
}
