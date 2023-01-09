import aquality.selenium.browser.AqualityServices;
import utils.ConfigUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection dbConnection = null;

    public static Connection getInstance(){
        try {
            if (dbConnection == null) {
                String connectionString = ConfigUtils.getConnectionString();
                dbConnection = DriverManager.getConnection(connectionString, ConfigUtils.getUser(),
                        ConfigUtils.getPassword());
            }
        } catch (SQLException e) {
            AqualityServices.getLogger().error("Error when trying to get connection. " + e.getMessage());
        }
        return dbConnection;
    }

    public static void closeConnection(){
        try {
            if (!isConnectionClosed()) {
                dbConnection.close();
            }
        } catch (SQLException e) {
            AqualityServices.getLogger().error("Error when trying to close connection. " + e.getMessage());
        }
    }

    public static boolean isConnectionClosed(){
        try {
            return dbConnection == null || dbConnection.isClosed();
        } catch (SQLException e) {
            AqualityServices.getLogger().error("Connection wasn't closed. " + e.getMessage());
        }
        return false;
    }
}