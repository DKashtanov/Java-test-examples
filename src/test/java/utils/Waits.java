package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static patterns.Singleton.getDriver;

public class Waits {

    public static WebElement waitElementIsClicable(By locator) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitElementIsSelected(By locator) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(locator));
    }
}