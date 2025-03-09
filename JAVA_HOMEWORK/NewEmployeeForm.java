package JAVA_HOMEWORK;

import javax.swing.*;
import java.sql.*;

public class NewEmployeeForm extends JFrame {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1522:orcl"; // Modify if needed
    private static final String DB_USER = "system"; // Replace with your Oracle username
    private static final String DB_PASSWORD = "12345"; // Replace with your Oracle password

    public NewEmployeeForm() {
        setTitle("New Employee Form");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblEmpId = new JLabel("Employee ID:");
        lblEmpId.setBounds(30, 20, 130, 30);
        add(lblEmpId);
        JTextField txtEmpId = new JTextField();
        txtEmpId.setBounds(180, 20, 150, 30);
        add(txtEmpId);

        JLabel lblFName = new JLabel("First Name:");
        lblFName.setBounds(30, 60, 130, 30);
        add(lblFName);
        JTextField txtFName = new JTextField();
        txtFName.setBounds(180, 60, 150, 30);
        add(txtFName);

        JLabel lblLName = new JLabel("Last Name:");
        lblLName.setBounds(30, 100, 130, 30);
        add(lblLName);
        JTextField txtLName = new JTextField();
        txtLName.setBounds(180, 100, 150, 30);
        add(txtLName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(30, 140, 130, 30);
        add(lblAge);
        JTextField txtAge = new JTextField();
        txtAge.setBounds(180, 140, 150, 30);
        add(txtAge);

        JLabel lblMobile = new JLabel("Mobile Phone:");
        lblMobile.setBounds(30, 180, 130, 30);
        add(lblMobile);
        JTextField txtMobile = new JTextField();
        txtMobile.setBounds(180, 180, 150, 30);
        add(txtMobile);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 220, 130, 30);
        add(lblEmail);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(180, 220, 150, 30);
        add(txtEmail);

        JLabel lblSSN = new JLabel("Social Security Number:");
        lblSSN.setBounds(30, 260, 150, 30);
        add(lblSSN);
        JTextField txtSSN = new JTextField();
        txtSSN.setBounds(180, 260, 150, 30);
        add(txtSSN);

        JLabel lblSalary = new JLabel("Basic Salary:");
        lblSalary.setBounds(30, 300, 130, 30);
        add(lblSalary);
        JTextField txtSalary = new JTextField();
        txtSalary.setBounds(180, 300, 150, 30);
        add(txtSalary);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, 340, 130, 30);
        add(lblGender);
        JRadioButton radioMale = new JRadioButton("Male");
        radioMale.setBounds(180, 340, 70, 30);
        JRadioButton radioFemale = new JRadioButton("Female");
        radioFemale.setBounds(250, 340, 80, 30);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);
        add(radioMale);
        add(radioFemale);

        JLabel lblDepartment = new JLabel("Department:");
        lblDepartment.setBounds(30, 380, 130, 30);
        add(lblDepartment);
        String[] departments = {"IT", "Finance", "Accounting"};
        JComboBox<String> comboDepartment = new JComboBox<>(departments);
        comboDepartment.setBounds(180, 380, 150, 30);
        add(comboDepartment);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(180, 450, 100, 40);
        add(btnSave);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(300, 450, 100, 40);
        add(btnClose);

        setVisible(true);

        btnSave.addActionListener(e -> {
            try {
                String empId = txtEmpId.getText();
                String firstName = txtFName.getText();
                String lastName = txtLName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String mobile = txtMobile.getText();
                String email = txtEmail.getText();
                String ssn = txtSSN.getText();
                double basicSalary = Double.parseDouble(txtSalary.getText());
                String gender = radioMale.isSelected() ? "Male" : "Female";
                String department = comboDepartment.getSelectedItem().toString();

                double allowance = department.equalsIgnoreCase("IT") ? 100000.0 : 0.0;
                double deductions = 0.03 * basicSalary;
                double grossSalary = basicSalary + allowance;
                double netSalary = grossSalary - deductions;

                // Save to Oracle
                insertEmployee(empId, firstName, lastName, age, mobile, email, ssn, gender, department);
                insertSalary(empId, basicSalary, allowance, deductions, grossSalary, netSalary);

                JOptionPane.showMessageDialog(null, "Employee and salary data saved successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        btnClose.addActionListener(e -> dispose());
    }

    private void insertEmployee(String empId, String firstName, String lastName, int age, String mobile, String email, String ssn, String gender, String department) {
        String sql = "INSERT INTO JAVA_EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, AGE, MOBILE_PHONE, EMAIL, SOCIAL_SEC_NO, GENDER, DEPARTMENT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, age);
            pstmt.setString(5, mobile);
            pstmt.setString(6, email);
            pstmt.setString(7, ssn);
            pstmt.setString(8, gender);
            pstmt.setString(9, department);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }
    }

    private void insertSalary(String empId, double basicSalary, double allowance, double deductions, double grossSalary, double netSalary) {
        String sql = "INSERT INTO EMP_SALARY (EMPLOYEE_ID, BASIC_SALARY, ALLOWANCE, DEDUCTIONS, GROSS_SALARY, NET_SALARY) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empId);
            pstmt.setDouble(2, basicSalary);
            pstmt.setDouble(3, allowance);
            pstmt.setDouble(4, deductions);

            pstmt.setDouble(5, grossSalary);
            pstmt.setDouble(6, netSalary);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new NewEmployeeForm();
    }
}
