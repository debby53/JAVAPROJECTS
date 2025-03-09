package JAVA_PRACTICAL_QUESTIONS;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientsTable {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@//localhost:1522/orcl";
      String username="system";
      String password="12345";


      try(Connection conn= DriverManager.getConnection(url,username,password);
          Statement stm= conn.createStatement()) {

          String createTable="CREATE TABLE javaPatients("+
                  "patientName varchar2(50) not null," +
                  "patientId varchar2(40)  primary key not null," +
                  "diseaseType varchar2(30) not null," +
                  "daysAdmitted NUMBER not null," +
                  "haveInsurance varchar2(10) not null," +
                  "totalBill NUMBER not null" +
                  ")";

          stm.executeUpdate(createTable);
          System.out.println("table created Successfully");




      } catch (SQLException e) {
         e.printStackTrace();

      }
    }
}
