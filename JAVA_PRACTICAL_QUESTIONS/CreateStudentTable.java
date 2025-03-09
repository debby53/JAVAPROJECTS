package JAVA_PRACTICAL_QUESTIONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStudentTable {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@//localhost:1522/orcl";
        String username="system";
        String password="12345";

        try (Connection conn= DriverManager.getConnection(url,username,password);
            Statement stm=conn.createStatement()){
                String createTable="CREATE TABLE JAVASTUDENT("  + "first_name VARCHAR2(50) NOT NULL, "
                        + "last_name VARCHAR2(50) NOT NULL, "
                        + "dob DATE NOT NULL, "
                        + "gender VARCHAR2(10) CHECK (gender IN ('Male', 'Female')), "
                        + "course VARCHAR2(50) NOT NULL, "
                        + "fees NUMBER(10,2) NOT NULL, "
                        + "department VARCHAR2(50) NOT NULL"
                        + ")";
                stm.executeUpdate(createTable);
                System.out.println("Table 'students' created successfully in Oracle Database.");
            } catch (SQLException e) {
        e.printStackTrace();
    }


    }
}
