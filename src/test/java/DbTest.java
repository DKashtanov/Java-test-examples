import org.testng.annotations.Test;
import utils.ConfigUtils;

public class DbTest {

    @Test
    public void getTestsMinWorkingTime() {
        DbQuery.executeQuery(ConfigUtils.selectTestsMinWorkingTime, ConfigUtils.getTestsMinWorkingTimeFileName());
    }

    @Test
    public void getProjectsAndCountOfTests() {
        DbQuery.executeQuery(ConfigUtils.selectProjectsAndCountOfTests, ConfigUtils.getProjectsAndCountOfTestsFileName());
    }

    @Test
    public void getTestsRunAfterDate() {
        DbQuery.executeQuery(ConfigUtils.selectTestsRunAfterDate, ConfigUtils.getTestsRunAfterDateFileName());
    }

    @Test
    public void getTotalTestsByBrowser() {
        DbQuery.executeQuery(ConfigUtils.selectTotalTestsByBrowser, ConfigUtils.getTotalTestsByBrowserFileName());
    }
}