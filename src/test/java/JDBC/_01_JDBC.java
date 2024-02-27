package JDBC;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class _01_JDBC {
    Statement statement;
    Connection connection;
    @BeforeMethod
    public void DBConnection() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/employees";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    @AfterMethod
    public void DBConnectionClose() throws SQLException {
        connection.close();
    }
    @Test
    public void test() throws SQLException {
       ResultSet rs = statement.executeQuery("select * from employees");

    }
}
