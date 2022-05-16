package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee {


    public static void main(String[] args) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","tinku","tiger");
            Statement statement = connection.createStatement();
            statement.executeUpdate("create table employee(eno number, ename varchar(12),esal number)");

            System.out.println("table created");

            connection.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }

}
