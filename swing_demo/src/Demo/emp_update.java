package Demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class emp_update {

    public static void main(String[] args) {
           String  value;
           int eid;
           double esal;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","tinku","tiger");
            Statement statement = connection.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));



                System.out.println("Enter Epm id: ");
               // int eno = Integer.parseInt(bufferedReader.readLine());
                   value = bufferedReader.readLine();
                   eid = Integer.parseInt(value);

                System.out.println("Enter Epm new sal: ");
                //double esal = Double.parseDouble(bufferedReader.readLine());
                value = bufferedReader.readLine();
                esal = Double.parseDouble(value);



                int count = statement.executeUpdate("update employee set esal = "+esal+"where eno = "+eid);
                if (count>0){
                    System.out.println(count +" rows updated");
                }
                else {
                    System.out.println("no rows update");
                }
               // System.out.println("Do you want to more Record:[yes/no]");

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
