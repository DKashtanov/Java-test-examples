package pages;

import elements.Label;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private final By UNIQUE_ELEMENT = By.xpath("//div[@class='home-content']");
    private final By ALERTS_FRAMES_WINDOWS = By.xpath("//div[contains(@class,'card mt-4 top-card')][3]");
    private final By ELEMENTS = By.xpath("//div[contains(@class,'card mt-4 top-card')][1]");

    public boolean isMainPageOpen(){
        return isPageOpen(UNIQUE_ELEMENT);
    }
    public void openAlertsFramesWindows(){
        Label.click(ALERTS_FRAMES_WINDOWS);
    }
}