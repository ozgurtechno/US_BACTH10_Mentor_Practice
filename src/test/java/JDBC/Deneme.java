package JDBC;

import org.testng.annotations.Test;
import utilities.DBUtilities;

public class Deneme extends DBUtilities {

    @Test
    public void getBirthday() {

        // GIVEN
        // we can create our own test employee and send it to employees...

        // WHEN
        var result = getData("select * from employees where first_name=\"Saniya\"", "employees");
        System.out.println(result);

        // THEN
        // we should be able to retrieve our test data

    }
}
