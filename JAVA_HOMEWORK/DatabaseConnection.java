package JAVA_HOMEWORK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1522:orcl"; // Change if using another DB service name
    private static final String USER = "system"; // Replace with Oracle username
    private static final String PASSWORD = "12345"; // Replace with Oracle password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
