package tests;

import org.testng.Assert;
import pages.AlertPage;
import pages.MainPage;
import utils.Alert;
import org.testng.annotations.Test;

public class TestAlert extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final AlertPage alertPage = new AlertPage();

    @Test
    public void testAlert() {
        mainPage.openAlertsFramesWindows();
        alertPage.openAlertsForm();
        Assert.assertTrue(alertPage.isAlertPageOpen(), "Alert page wasn't opened");
        alertPage.clickFirstAlert();
        Alert.switchToAlert();
        String text = Alert.getAlertText();
        Assert.assertEquals(text, "You clicked a button", "Texts don't match");
        Alert.alertOk();
        alertPage.clickThirdAlert();
        String text2 = Alert.getAlertText();
        Assert.assertEquals(text2, "Do you confirm action?", "Texts don't match");
        Alert.alertOk();
        String aptext = alertPage.getThirdAlertText();
        Assert.assertEquals(aptext, "You selected Ok", "Texts don't match");
        alertPage.clickFourthAlert();
        String text3 = Alert.getAlertText();
        Assert.assertEquals(text3, "Please enter your name", "Texts don't match");
        Alert.alertOk();
    }
}