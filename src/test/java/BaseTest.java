import org.testng.annotations.AfterClass;

public class BaseTest {

    @AfterClass
    public void closeConnection(){
        DbConnection.closeConnection();
    }
}