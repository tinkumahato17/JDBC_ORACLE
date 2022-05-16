
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

class Registration extends JFrame {


    JLabel lname, ladd, lemail, lphone, lyear, ldept;
    JTextField tname, tadd, temail, tphone, tyear, tdept;
    JButton btn_register, btn_clear;
    String Sname, SAdd, SEmail, SPhone, SYear, SDept;

    public Registration() {

        lname = new JLabel("Name :");
        ladd = new JLabel("Address : ");
        lemail = new JLabel("Email : ");
        lphone = new JLabel("phone : ");
        lyear = new JLabel("year : ");
        ldept = new JLabel("Dept : ");
        tname = new JTextField(15);
        tadd = new JTextField(15);
        temail = new JTextField(15);
        tphone = new JTextField(15);
        tyear = new JTextField(15);
        tdept = new JTextField(15);
        btn_register = new JButton("Register");
        btn_clear = new JButton("Clear");

        add(lname);
        add(tname);
        add(ladd);
        add(tadd);
        add(lemail);
        add(temail);
        add(lphone);
        add(tphone);
        add(lyear);
        add(tyear);
        add(ldept);
        add(tdept);
        add(btn_register);
        add(btn_clear);

        setLayout(new GridLayout(10, 1, 0, 10));
        setSize(400, 400);
        setVisible(true);

        btn_register.addActionListener(e -> {
            try {


                Sname = tname.getText();
                SEmail = temail.getText();
                SPhone = tphone.getText();
                SAdd = tadd.getText();
                SYear = tyear.getText();
                SDept = tdept.getText();
                // System.out.println(Sname);

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tinku", "tiger");
                String ins = "insert into Student(name,email,phone,address,year,dept) values (?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(ins);
                int result = preparedStatement.executeUpdate();
                if(result > 1){
                    System.out.println("inserted");
                }else{
                    System.out.println("failed");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            //  JOptionPane.showMessageDialog(null,"insert Succusfully");

        });

        btn_clear.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tname.setText(" ");
                tadd.setText(" ");
                temail.setText(" ");
                tphone.setText(" ");
                tyear.setText(" ");
                tdept.setText(" ");
            }
        });
    }

    public static void main(String args[]) {
        Registration r = new Registration();
    }

}