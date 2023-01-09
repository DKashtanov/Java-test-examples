package utils;

import org.apache.commons.lang3.RandomStringUtils;
import testData.DataProvider;

public class RandomUtils {

    public static String getRandomString(){
        return RandomStringUtils.randomAlphabetic(Integer.parseInt(DataProvider.TEST_DATA.getMessageLength()));
    }
}