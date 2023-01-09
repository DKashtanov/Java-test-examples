package utils;

import aquality.selenium.browser.AqualityServices;
import testData.DataProvider;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtils {

    public static void setClipboard(String text){
        StringSelection path = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(path, null);
    }

    public static void makeActionSaveImage(){
        try {
            Robot robot = new Robot();
            robot.delay(DataProvider.TEST_DATA.getRobotDelayBefore());
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            pressEnter();
        } catch (AWTException e) {
            AqualityServices.getLogger().error("Robot can't do a save image action. " + e.getMessage());
        }
    }

    public static void pressEnter(){
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(DataProvider.TEST_DATA.getRobotDelayAfter());
        } catch (AWTException e) {
            AqualityServices.getLogger().error("Robot can't press Enter. " + e.getMessage());
        }
    }

    public static void pressTab(){
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(DataProvider.TEST_DATA.getRobotDelayBetweenTabs());
        } catch (AWTException e) {
            AqualityServices.getLogger().error("Robot can't press Tab. " + e.getMessage());
        }
    }

    public static void pressControlV(){
        try {
            Robot robot = new Robot();
            robot.delay(DataProvider.TEST_DATA.getRobotDelayBefore());
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(DataProvider.TEST_DATA.getRobotDelayAfter());
        } catch (AWTException e) {
            AqualityServices.getLogger().error("Robot can't press Control+V. " + e.getMessage());
        }
    }

    public static void setImageName(String imageName){
        try {
            Robot robot = new Robot();
            robot.delay(DataProvider.TEST_DATA.getRobotDelayWindow());
            setClipboard(imageName);
            robot.delay(DataProvider.TEST_DATA.getRobotDelayWindow());
            pressControlV();
            robot.delay(DataProvider.TEST_DATA.getRobotDelayAfter());
        } catch (AWTException e) {
            AqualityServices.getLogger().error("Robot can't set an image name. " + e.getMessage());
        }
    }

    public static void pressTabByDefault(){
        int tabCount = DataProvider.TEST_DATA.getTabCount();
        while (tabCount <= DataProvider.TEST_DATA.getDefaultTabsCount()){
            pressTab();
            tabCount++;
        }
    }

    public static void setPathToSaveImage(String path){
        pressTabByDefault();
        pressEnter();
        setClipboard(path);
        pressControlV();
        pressEnter();
    }

    public static void acceptFileSaving(){
        pressTabByDefault();
        pressEnter();
    }

    public static void downloadImage(String path, String imageName) {
        makeActionSaveImage();
        setImageName(imageName);
        setPathToSaveImage(path);
        acceptFileSaving();
    }
}