package pages;

import elements.Button;
import elements.Label;
import elements.TextField;
import org.openqa.selenium.By;

public class WindowsPage extends BasePage {

    private final By UNIQUE_ELEMENT = By.id("browserWindows");
    private final By BROWSER_WINDOWS_ITEM = By.xpath("//*[@id='item-0']/span[text()='Browser Windows']");
    private final By NEW_TAB_BUTTON = By.id("tabButton");
    private final By NEW_WINDOW_BUTTON = By.id("windowButton");
    private final By NEW_WINDOW_MESSAGE_BUTTON = By.id("messageWindowButton");
    private final By NEW_TAB_TEXT = By.id("sampleHeading");
    private final By NEW_WINDOW_TEXT = By.id("sampleHeading");
    private final By NEW_WINDOW_MESSAGE_TEXT = By.cssSelector("body");

    public boolean isWindowsPageOpen(){
        return isPageOpen(UNIQUE_ELEMENT);
    }

    public void openBrowserWindowsForm(){
        Label.click(BROWSER_WINDOWS_ITEM);
    }

    public void clickOnNewTab(){
        Button.click(NEW_TAB_BUTTON);
    }

    public void clickOnNewWindow(){
        Button.click(NEW_WINDOW_BUTTON);
    }

    public void clickOnNewWindowMessage(){
        Button.click(NEW_WINDOW_MESSAGE_BUTTON);
    }

    public String getNewTabText(){
        return TextField.getText(NEW_TAB_TEXT);
    }

    public String getNewWindowText(){
        return TextField.getText(NEW_WINDOW_TEXT);
    }

    public String getNewWindowMessageText(){
        return TextField.getText(NEW_WINDOW_MESSAGE_TEXT);
    }
}