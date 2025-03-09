package JAVA_HOMEWORK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("EMPLOYEE REGISTRATION FORM");
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245, 245, 220));

        // Employee ID
        JLabel empId = new JLabel("Employee ID:");
        empId.setBounds(30, 50, 130, 30);
        frame.add(empId);
        JTextField txtId = new JTextField();
        txtId.setBounds(180, 50, 150, 30);
        frame.add(txtId);

        // First Name
        JLabel FName = new JLabel("First Name:");
        FName.setBounds(30, 100, 130, 30);
        frame.add(FName);
        JTextField txtFName = new JTextField();
        txtFName.setBounds(180, 100, 150, 30);
        frame.add(txtFName);

        // Last Name
        JLabel LName = new JLabel("Last Name:");
        LName.setBounds(30, 150, 130, 30);
        frame.add(LName);
        JTextField txtLName = new JTextField();
        txtLName.setBounds(180, 150, 150, 30);
        frame.add(txtLName);

        // Age
        JLabel EmpAge = new JLabel("Age:");
        EmpAge.setBounds(30, 200, 130, 30);
        frame.add(EmpAge);
        JTextField txtAge = new JTextField();
        txtAge.setBounds(180, 200, 150, 30);
        frame.add(txtAge);

        // Gender
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(30, 250, 130, 30);
        frame.add(gender);

        JRadioButton radioFemale = new JRadioButton("Female");
        radioFemale.setBounds(180, 250, 100, 30);
        frame.add(radioFemale);

        JRadioButton radioMale = new JRadioButton("Male");
        radioMale.setBounds(280, 250, 100, 30);
        frame.add(radioMale);

        // Button Group for Gender
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioFemale);
        genderGroup.add(radioMale);

        // Salary
        JLabel salary = new JLabel("Salary:");
        salary.setBounds(30, 300, 130, 30);
        frame.add(salary);
        JTextField txtSalary = new JTextField();
        txtSalary.setBounds(180, 300, 150, 30);
        frame.add(txtSalary);

        // Department
        JLabel department = new JLabel("Department:");
        department.setBounds(30, 350, 130, 30);
        frame.add(department);

        String[] departmentList = { "-----please select -----","IT", "Finance", "HR", "Accounting"};
        JComboBox<String> comboDepartment = new JComboBox<>(departmentList);
        comboDepartment.setBounds(180, 350, 150, 30);
        frame.add(comboDepartment);

        // Hobbies
        JLabel hobbies = new JLabel("Hobbies:");
        hobbies.setBounds(30, 400, 130, 30);
        frame.add(hobbies);

        JCheckBox chkFoot = new JCheckBox("Football");
        chkFoot.setBounds(180, 400, 130, 30);
        frame.add(chkFoot);

        JCheckBox chkVolley = new JCheckBox("Volleyball");
        chkVolley.setBounds(180, 430, 130, 30);
        frame.add(chkVolley);

        JCheckBox chkCricket = new JCheckBox("Cricket");
        chkCricket.setBounds(180, 460, 130, 30);
        frame.add(chkCricket);

        JCheckBox chkSwimming = new JCheckBox("Swimming");
        chkSwimming.setBounds(180, 490, 130, 30);
        frame.add(chkSwimming);

        // Terms and Conditions Checkbox
        JCheckBox confirm = new JCheckBox("I accept terms and conditions");
        confirm.setBounds(30, 530, 250, 30);
        frame.add(confirm);

        // Save Button
        JButton save = new JButton("Save");
        save.setBounds(180, 580, 100, 40);
        save.setBackground(new Color(76, 175, 80));
        save.setForeground(Color.WHITE);
        frame.add(save);

        frame.setVisible(true);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  empId=txtId.getText();
                String firstName=txtFName.getText();
                String lastName=txtLName.getText();
                int age=Integer.parseInt(txtAge.getText());

                String gender ="";
                if(radioFemale.isSelected()){
                    gender="Female";
                }if(radioMale.isSelected()){
                    gender="Male";
                }
                Long salary=Long.parseLong(txtSalary.getText());
                String  department=comboDepartment.getSelectedItem().toString();
                String hobbies="";
                if(chkFoot.isSelected()){
                    hobbies=hobbies+ "Foot Ball";
                }
                if(chkVolley.isSelected()){
                    hobbies=hobbies + "Vollye ball";
                }
                if(chkCricket.isSelected()){
                    hobbies+= "Cricket ";
                }
                if ((chkSwimming.isSelected())){
                    hobbies+= "swimming pool";
                }
                 boolean conf=false;
                if(confirm.isSelected()){
                    conf=true;
                }
//                Display entered info
                System.out.println("employee id "+ empId);
                System.out.println("First Name"+ firstName);
                System.out.println("Last Name "+ lastName);
                System.out.println("age "+age);
                System.out.println("Gender "+gender);
                System.out.println("salary "+ salary);
                System.out.println("department " + department);
                System.out.println("hobbies "+hobbies);
                System.out.println("confirm "+ conf);


            }
        });
    }
}
