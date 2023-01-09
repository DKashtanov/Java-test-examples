package utils;

import java.util.Map;

public class ConfigUtils {

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String CONNECTION_STRING = "connectionString";
    static Map<?, ?> config = ReaderUtils.readJsonFile("./src/test/resources/config.json");
    static Map<?, ?> testData = ReaderUtils.readJsonFile("./src/test/resources/testData.json");

    public static String selectProjectsAndCountOfTests = ReaderUtils.readTxtFile(
            "./src/test/resources/sql/selectProjectsAndCountOfTests.txt");
    public static String selectTestsMinWorkingTime = ReaderUtils.readTxtFile(
            "./src/test/resources/sql/selectTestsMinWorkingTime.txt");
    public static String selectTestsRunAfterDate = ReaderUtils.readTxtFile(
            "./src/test/resources/sql/selectTestsRunAfterDate.txt");
    public static String selectTotalTestsByBrowser = ReaderUtils.readTxtFile(
            "./src/test/resources/sql/selectTotalTestsByBrowser.txt");

    public static String getUser(){
        return (String) config.get(USER);
    }

    public static String getPassword(){
        return (String) config.get(PASSWORD);
    }

    public static String getConnectionString(){
        return (String) config.get(CONNECTION_STRING);
    }

    public static String getTestsMinWorkingTimeFileName(){
        return (String) testData.get("testsMinWorkingTimeFileName");
    }

    public static String getProjectsAndCountOfTestsFileName(){
        return (String) testData.get("projectsAndCountOfTestsFileName");
    }

    public static String getTestsRunAfterDateFileName(){
        return (String) testData.get("testsRunAfterDateFileName");
    }

    public static String getTotalTestsByBrowserFileName(){
        return (String) testData.get("totalTestsByBrowserFileName");
    }
}