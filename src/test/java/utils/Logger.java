package utils;

import aquality.selenium.browser.AqualityServices;

public class Logger {

    private int step;

    public void logStep(String message){
        AqualityServices.getLogger().info(String.format("STEP %d. %s is starting...", ++step, message));
    }
}