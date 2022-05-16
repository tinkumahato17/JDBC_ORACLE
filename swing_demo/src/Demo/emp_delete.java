package Demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class emp_delete {

    public static void main(String[] args) {


            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","tinku","tiger");
                Statement statement = connection.createStatement();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                while (true) {

                    System.out.println("Enter deletion Epm id: ");
                    int eno = Integer.parseInt(bufferedReader.readLine());


                    int count = statement.executeUpdate("delete from employee where eno = "+eno);
                    if (count>0){
                        System.out.println(count +" record deleted");
                    }
                    else {
                        System.out.println("no record deleted");
                    }
                    System.out.println("Do you want to more Record:[yes/no]");
                    String ch = bufferedReader.readLine();
                    if(ch.equalsIgnoreCase("no")){
                        break;
                    }
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

    }
}
