package JDBC;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;


public class _01_JDBC {

    @Test
    public void DBConnection() {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/employees";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery("select * from employees");
            rs.next(); // moves the cursor to the next row
            String firstName = rs.getString(3); // Gets the value from the 2nd column of the 1st row
            System.out.println("firstName = " + firstName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
