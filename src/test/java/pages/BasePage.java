package pages;

import elements.Label;
import org.openqa.selenium.By;

public class BasePage {

    protected boolean isPageOpen(By locator){
        return Label.getElement(locator).isDisplayed();
    }
}