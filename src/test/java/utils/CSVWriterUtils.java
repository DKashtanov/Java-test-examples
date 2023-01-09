package utils;

import aquality.selenium.browser.AqualityServices;
import com.opencsv.CSVWriter;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSVWriterUtils {

    public static void makeCSVFile(ResultSet data, String fileName) {
        try {
            FileWriter fWriter = new FileWriter(String.format("%s.csv", fileName), false);
            CSVWriter csvWriter = new CSVWriter(fWriter);
            csvWriter.writeAll(data, true);
            csvWriter.close();
            fWriter.close();
        } catch (IOException | SQLException e) {
            AqualityServices.getLogger().error("Error when trying to make a CSV file. " + e.getMessage());
        }
    }
}