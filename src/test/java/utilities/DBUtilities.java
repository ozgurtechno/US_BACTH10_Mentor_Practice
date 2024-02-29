package utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtilities {

    protected static Statement statement;

    public static List<List<String>> getData(String query, String database) {

        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/" + database;
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        List<List<String>> returnList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) { // next returns false if there is no next row. We don't need to get number of rows of our result
                List<String> row = new ArrayList<>();
                int columnCount = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    row.add(value);
                }
                returnList.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return returnList;
    }

}
