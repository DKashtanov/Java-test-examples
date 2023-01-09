package utils;

import static patterns.Singleton.getDriver;

public class Alert {

    public static void switchToAlert() {
        getDriver().switchTo().alert();
    }

    public static void alertOk() {
        getDriver().switchTo().alert().accept();
    }

    public static void alertDismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    public static String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

    public static void alertSendKeys(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }
}