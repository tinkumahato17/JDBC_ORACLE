package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class emp_select {
    public static void main(String[] args) {


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tinku", "tiger");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee");

            while (resultSet.next()) {
                int eid = resultSet.getInt(1);
                String ename = resultSet.getString(2);
                double esal = resultSet.getDouble(3);

                System.out.println("Emp id: " + eid);
                System.out.println("Emp name: " + ename);
                System.out.println("Emp salary: " + esal);
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
