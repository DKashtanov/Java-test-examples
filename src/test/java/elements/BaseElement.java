package elements;

import utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {

    public static void click(By locator){
        Waits.waitElementIsClicable(locator).click();
    }

    public static WebElement getElement(By locator){
        return Waits.waitElementIsSelected(locator);
    }
}