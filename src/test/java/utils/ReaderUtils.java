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

    public static <T> T convertContentToObject(String content, Class<T> type){
        T result = null;
        try{
            result = new Gson().fromJson(content, type);
        }catch (JsonIOException | JsonSyntaxException e){
            AqualityServices.getLogger().error(String.format("Error when trying to extract values with type " +
                    "%s from content %s: %s", type, content, e.getMessage()));
        }
        return result;
    }

    public static String convertMapToJson(Map<?, ?> fileName){
        try {
            return new Gson().toJson(fileName);
        } catch (JsonIOException | JsonSyntaxException e) {
            AqualityServices.getLogger().error("Can't convert the file. " + e.getMessage());
        }
        return null;
    }
}