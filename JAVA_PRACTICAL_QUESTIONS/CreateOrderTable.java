package JAVA_PRACTICAL_QUESTIONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOrderTable {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@//localhost:1522/orcl";
        String username="system";
        String password="12345";

        try (Connection conn= DriverManager.getConnection(url,username,password);
            Statement stm= conn.createStatement()){

            String createTable = "CREATE TABLE javaOrder(" +
                    "customerName varchar2(100) not null," +
                    "productCategory varchar2(50) not null," +
                    "productName varchar2(50) not null," +
                    "price NUMBER," +
                    "quantity NUMBER, " +
                    "totalAmount NUMBER" +
                    ")";
            stm.executeUpdate(createTable);
            System.out.println("Table 'javaOrder' created successfully in Oracle Database.");




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
