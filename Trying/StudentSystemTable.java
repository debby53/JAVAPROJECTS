package Trying;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentSystemTable {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@//localhost:1522/orcl";
        String username="system";
        String password="12345";

        try(Connection conn = DriverManager.getConnection(url,username,password);
            Statement stm= conn.createStatement()) {
            String createTable="CREATE TABLE try("
                    +"firstName varchar2(30) not null," +
                    "lastName varchar2(30) not null," +
                    "dob DATE not null," +
                    "gender varchar2(30) not null," +
                    "fees NUMBER not null " +
                    ")";
            stm.executeUpdate(createTable);
            System.out.println("table created successfully ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
