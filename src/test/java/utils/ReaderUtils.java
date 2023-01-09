package utils;

import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class ReaderUtils {

    public static Map<?, ?> readJsonFile(String fileName){
    try {
        FileReader reader = new FileReader(fileName);
        return new Gson().fromJson(reader, Map.class);
    } catch (FileNotFoundException | JsonIOException | JsonSyntaxException e) {
        AqualityServices.getLogger().error("Can't read the file. " + e.getMessage());
    }
        return null;
    }

    public static String readTxtFile(String fileName) {
        File file = new File(fileName);
        String content = "";
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                content = content.concat(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error("Can't read the file. " + e.getMessage());
        }
        return content;
    }
}