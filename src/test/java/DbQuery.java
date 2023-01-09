import aquality.selenium.browser.AqualityServices;
import utils.CSVWriterUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery {

    public static ResultSet executeQuery(String query, String fileName) {
        ResultSet result = null;
        Statement statement = null;
        try {
            statement = DbConnection.getInstance().createStatement();
            result = statement.executeQuery(query);

            if(statement.execute(query)){
                result = statement.getResultSet();
                CSVWriterUtils.makeCSVFile(result, fileName);
            }
            return result;
        } catch (SQLException e) {
            AqualityServices.getLogger().error("Error when trying to execute SQL query. " + e.getMessage());
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    AqualityServices.getLogger().error("Error when trying to execute SQL query. " + e.getMessage());
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    AqualityServices.getLogger().error("Error when trying to execute SQL query. " + e.getMessage());
                }
            }
        }
        return null;
    }
}