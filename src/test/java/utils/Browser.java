package utils;

import static patterns.Singleton.getDriver;
import java.util.ArrayList;

public class Browser {

    public static void openUrl(String url){
        getDriver().get(url);
    }

    public static void switchToWindow(int num){
        ArrayList<String> newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(num));
    }

    public static void closeWindow(){
        getDriver().close();
    }
}