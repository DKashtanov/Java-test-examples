import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testData.DataProvider;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class BaseTest {

    @BeforeTest
    public void openBrowser(){
        getBrowser().maximize();
        getBrowser().goTo(DataProvider.CONFIG_DATA.getUrl());
    }

    @AfterTest
    public void closeBrowser(){
        getBrowser().quit();
    }
}