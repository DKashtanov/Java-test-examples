package elements;

import utils.Waits;
import org.openqa.selenium.By;

public class TextField extends BaseElement {

    public static String getText(By locator) {
        return Waits.waitElementIsSelected(locator).getText();
    }
}