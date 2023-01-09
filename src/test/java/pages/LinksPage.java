package pages;

import elements.Label;
import elements.Link;
import org.openqa.selenium.By;

public class LinksPage extends BasePage {

    private final By UNIQUE_ELEMENT = By.id("linkWrapper");
    private final By ELEMENTS_LEFT_MENU = By.xpath("//div[(text()='Elements')]");
    private final By LINKS_FROM_ELEMENTS = By.xpath("//*[@id='item-5']/span[text()='Links']");
    private final By LINK_HOME = By.id("simpleLink");

    public boolean isLinksPageOpen(){
        return isPageOpen(UNIQUE_ELEMENT);
    }

    public void openElementsFromLeftMenu(){
        Label.click(ELEMENTS_LEFT_MENU);
    }

    public void openLinksFromElements(){
        Label.click(LINKS_FROM_ELEMENTS);
    }

    public void clickHomeLink(){
        Link.click(LINK_HOME);
    }
}