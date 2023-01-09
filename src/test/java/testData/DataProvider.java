package testData;

import utils.ReaderUtils;
import java.nio.file.Paths;
import java.util.Map;

public class DataProvider {

    private static final String CONFIG_PATH = "./src/test/resources/config.json";
    private static final String TEST_DATA_PATH = "./src/test/resources/testData.json";
    public static final ConfigData CONFIG_DATA = readData(CONFIG_PATH, ConfigData.class);
    public static final TestData TEST_DATA = readData(TEST_DATA_PATH, TestData.class);

    public static String setImagePath() {
        return Paths.get(TEST_DATA.getPathToFolderSrc(), TEST_DATA.getPathToFolderTest(),
                TEST_DATA.getPathToFolderResources()).toFile().getAbsolutePath();
    }

    private static <T> T readData(String filePath, Class<T> type){
        Map<?, ?> data = ReaderUtils.readJsonFile(filePath);
        String jsonStr = ReaderUtils.convertMapToJson(data);
        return ReaderUtils.convertContentToObject(jsonStr, type);
    }
}