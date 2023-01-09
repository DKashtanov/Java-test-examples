package tests;

import org.testng.Assert;
import pages.LinksPage;
import pages.MainPage;
import pages.WindowsPage;
import utils.Browser;
import org.testng.annotations.Test;

public class TestWindowsHandles extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final WindowsPage windowPage = new WindowsPage();
    private final LinksPage linksPage = new LinksPage();

    @Test
    public void testWindowsHandles(){
        mainPage.openAlertsFramesWindows();
        windowPage.openBrowserWindowsForm();
        Assert.assertTrue(windowPage.isWindowsPageOpen(), "Windows page wasn't opened");
        windowPage.clickOnNewTab();
        Browser.switchToWindow(1);
        String w1Page = windowPage.getNewTabText();
        Assert.assertEquals(w1Page, "This is a sample page", "The texts don't match");
        Browser.closeWindow();
        Browser.switchToWindow(0);
        linksPage.openElementsFromLeftMenu();
        linksPage.openLinksFromElements();
        linksPage.clickHomeLink();
        Browser.switchToWindow(1);
        Assert.assertTrue(mainPage.isMainPageOpen(), "The Main page wasn't opened");
        Browser.switchToWindow(0);
        Assert.assertTrue(linksPage.isLinksPageOpen(), "The Links page wasn't opened");
    }
}