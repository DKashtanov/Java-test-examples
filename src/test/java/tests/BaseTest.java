package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static patterns.Singleton.getDriver;

public abstract class BaseTest{

    @BeforeTest
    public void openBrowser(){
        getDriver().manage().window().maximize();
        getDriver().get("https://demoqa.com/");
    }

    @AfterTest
    public void closeBrowser(){
        getDriver().quit();
    }
}