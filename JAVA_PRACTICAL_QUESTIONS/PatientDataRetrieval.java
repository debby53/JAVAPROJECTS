package JAVA_PRACTICAL_QUESTIONS;



import javax.swing.*;
import java.sql.*;

public class PatientDataRetrieval {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@//localhost:1522/orcl";
        String username="system";
        String password="12345";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(url,username,password);
            String query="SELECT patientName,patientId FROM javaPatients ";
            Statement stm= conn.createStatement();
            ResultSet rs=stm.executeQuery(query);

            while (rs.next()){
                String name=rs.getString("patientName");
                String id=rs.getString("PatientId");


                System.out.println("the patient name is "+ name);
                System.out.println("the id is "+id);
            }




        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found ");
        } catch (SQLException e) {
            System.out.println( "connection not established "+e.getMessage());
        }
    }
}
