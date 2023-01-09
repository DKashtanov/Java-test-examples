package utils;

import testData.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getDataAndTime(){
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DataProvider.TEST_DATA.getDataTimeFormat());
        return dateFormat.format(dateNow);
    }
}