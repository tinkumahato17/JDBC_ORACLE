package Demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Emp_insert {

    public static void main(String[] args) {

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","tinku","tiger");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("Enter Epm id: ");
                int eno = Integer.parseInt(bufferedReader.readLine());

                System.out.println("Enter Epm name: ");
                String ename = bufferedReader.readLine();

                System.out.println("Enter Epm sal: ");
                double esal = Double.parseDouble(bufferedReader.readLine());

                preparedStatement.setInt(1,eno);
                preparedStatement.setString(2,ename);
                preparedStatement.setDouble(3,esal);

                int count = preparedStatement.executeUpdate();
                if (count>0){
                    System.out.println(count +" record inserted");
                }
                else {
                    System.out.println("no record inserted");
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
