package JAVA_HOMEWORK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUsers {

    public static void main(String[] args) {

        String dbUrl = "jdbc:oracle:thin:@//localhost:1522/orcl";
        String dbUser = "system";
        String dbPassword = "12345";

        //Inserting data

        String insertSQL = "INSERT INTO JAVA_USER (USER_NAME, USER_PASSWORD, STATUS) VALUES (?, ?, ?)";

        try(Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            PreparedStatement stmt = con.prepareStatement(insertSQL);
            Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter username: ");
            String username = sc.nextLine();

            System.out.println("Enter password: ");
            String password = sc.nextLine();

            System.out.println("Enter status (E for enabled, D for disabled): ");
            String status = sc.nextLine();

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3,status);

            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("User inserted successfully!");
            } else {
                System.out.println("Failed to insert user. ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

