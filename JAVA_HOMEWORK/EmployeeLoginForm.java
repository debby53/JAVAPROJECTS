package JAVA_HOMEWORK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class EmployeeLoginForm {
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1522/orcl";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "12345";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeLoginForm::new);
    }

    public EmployeeLoginForm() {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        JLabel userLb = new JLabel("Username:");
        userLb.setBounds(50, 50, 100, 25);
        frame.add(userLb);

        JTextField userTxt = new JTextField();
        userTxt.setBounds(150, 50, 150, 25);
        frame.add(userTxt);

        JLabel passLb = new JLabel("Password:");
        passLb.setBounds(50, 100, 100, 25);
        frame.add(passLb);

        JPasswordField passTxt = new JPasswordField();
        passTxt.setBounds(150, 100, 150, 25);
        frame.add(passTxt);

        JLabel message = new JLabel("");
        message.setBounds(50, 220, 300, 25);
        frame.add(message);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(50, 150, 100, 30);
        frame.add(loginBtn);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(200, 150, 100, 30);
        frame.add(saveBtn);

        loginBtn.addActionListener((ActionEvent e) -> {
            String username = userTxt.getText();
            String password = new String(passTxt.getPassword());

            if (authenticateUser(username, password)) {
                System.out.println("Login successful! Opening New Employee Form..."); // Debugging
                frame.dispose(); // Close login form

                SwingUtilities.invokeLater(() -> {
                    NewEmployeeForm newEmployeeForm = new NewEmployeeForm();
                    newEmployeeForm.setVisible(true);
                });
            } else {
                message.setText("Wrong username/password. Try again.");
                message.setForeground(Color.RED);
            }
        });

        saveBtn.addActionListener((ActionEvent e) -> {
            String username = userTxt.getText();
            String password = new String(passTxt.getPassword());

            if (saveData(username, password)) {
                message.setText("Data saved successfully!");
                message.setForeground(Color.GREEN);
            } else {
                message.setText("Failed to save data.");
                message.setForeground(Color.RED);
            }
        });

        frame.setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        String sql = "SELECT USER_PASSWORD FROM JAVA_USER WHERE USER_NAME = ? AND STATUS = 'E'";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("USER_PASSWORD");
                return storedPassword.equals(password); // Should hash passwords in real-world apps
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean saveData(String username, String password) {
        String sql = "INSERT INTO JAVA_USER (USER_NAME, USER_PASSWORD, STATUS) VALUES (?, ?, 'E')";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
