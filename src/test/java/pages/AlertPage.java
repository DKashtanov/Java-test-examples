package pages;

import elements.Button;
import elements.Label;
import elements.TextField;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    private final By UNIQUE_ELEMENT = By.id("javascriptAlertsWrapper");
    private final By ALERTS_ITEM = By.xpath("//*[@id='item-1']/span[text()='Alerts']");
    private final By ALERT_1_BUTTON = By.id("alertButton");
    private final By ALERT_2_BUTTON = By.id("timerAlertButton");
    private final By ALERT_3_BUTTON = By.id("confirmButton");
    private final By ALERT_4_BUTTON = By.id("promtButton");
    private final By ALERT_3_APPEARED_TEXT = By.id("confirmResult");
    private final By ALERT_4_APPEARED_TEXT = By.id("promptResult");

    public boolean isAlertPageOpen(){
        return isPageOpen(UNIQUE_ELEMENT);
    }

    public void openAlertsForm(){
        Label.click(ALERTS_ITEM);
    }

    public void clickFirstAlert(){
        Button.click(ALERT_1_BUTTON);
    }

    public void clickSecondAlert(){
        Button.click(ALERT_2_BUTTON);
    }

    public void clickThirdAlert(){
        Button.click(ALERT_3_BUTTON);
    }

    public void clickFourthAlert(){
        Button.click(ALERT_4_BUTTON);
    }

    public String getThirdAlertText(){
        return TextField.getText(ALERT_3_APPEARED_TEXT);
    }

    public String getFourthAlertText(){
        return TextField.getText(ALERT_4_APPEARED_TEXT);
    }
}