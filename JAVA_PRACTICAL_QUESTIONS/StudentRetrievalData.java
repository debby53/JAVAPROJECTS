package JAVA_PRACTICAL_QUESTIONS;

import java.sql.*;

public class StudentRetrievalData {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@//localhost:1522/orcl";
        String username="system";
        String  password="12345";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(url,username,password);
           String query="SELECT last_name,first_name From JAVASTUDENT";
            Statement stm= conn.createStatement();
            ResultSet rs= stm.executeQuery(query);

            while (rs.next()){
                String firstName=rs.getString("first_name");
                String lastName=rs.getString("last_name");

                System.out.println("the student first name is "+firstName);
                System.out.println("the student last name is "+lastName);
                System.out.println("---------------------------------");

            }




        } catch (ClassNotFoundException e) {
            System.out.println("class not found "+e.getMessage());
        } catch (SQLException e) {
            System.out.println("connection not established "+e.getMessage());
        }
    }
}
