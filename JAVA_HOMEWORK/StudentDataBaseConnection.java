package JAVA_HOMEWORK;

import javax.swing.*;
import java.sql.*;

public class StudentDataBaseConnection {

    public static void main(String[] args) {
//        define DB URL , username , password;
        String dbURL = "jdbc:oracle:thin:@//localhost:1522/orcl";
        String dbUsername ="system";
        String dbPassword ="12345";



//        Step 1. Register or load JDBC driver;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println(" JDBC Driver loaded successfully");
            Connection conn= DriverManager.getConnection(dbURL,dbUsername,dbPassword);
            //System.out.println("Connected successfully");

            // step 3
            Statement stm= conn.createStatement();
            // step 4: execute queries
            String sql = "SELECT ID, USER_NAME, USER_PASSWORD,STATUS FROM USERS";
            ResultSet rs=stm.executeQuery(sql);

//            if(rs.next()){
//                String status =rs.getString("STATUS");
//                if(status.equals("E")){
//                    JOptionPane.showMessageDialog(null,"WELCOME TO AUCA");
//                }else{
//                    JOptionPane.showMessageDialog(null,"Your account is disabled");
//                }
//            }

            //step 5 : process query result

            while(rs.next()){
                int studentId=rs.getInt("ID");
                String username=rs.getString("USER_NAME");
                String password=rs.getString("USER_PASSWORD");
                String status=rs.getString("STATUS");

                System.out.println("Student id " + studentId);
                System.out.println("username " + username);
                System.out.println("password " + password);
                System.out.println(" status " + status);
                System.out.println("-------------------------------------------------");


            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to Register JDBC Driver ::::: "+e.getMessage());
//       step2 .establish connection

            } catch (SQLException e ){
            System.out.println("data base error "+ e.getMessage());
        }
    }
}
