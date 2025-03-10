package Trying;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentSystem {
    public static void main(String[] args) {
        JFrame frame =new JFrame("Student form");
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        JLabel lblName1=new JLabel("First name");
        lblName1.setBounds(30,30,100,30);
        frame.add(lblName1);

        JTextField txtName1=new JTextField();
        txtName1.setBounds(150,30,100,30);
        frame.add(txtName1);

        JLabel lblName2=new JLabel("Last Name");
        lblName2.setBounds(30,80,100,30);
        frame.add(lblName2);

        JTextField txtName2=new JTextField();
        txtName2.setBounds(150,80,100,30);
        frame.add(txtName2);

        JLabel lblDate=new JLabel("Date of birth");
        lblDate.setBounds(30,120,100,30);
        frame.add(lblDate);

        JTextField txtDate=new JTextField();
        txtDate.setBounds(150,120,100,30);
        frame.add(txtDate);

        JLabel gender =new JLabel("Gender");
        gender.setBounds(30,150,100,30);
        frame.add(gender);

        JRadioButton radioFemale=new JRadioButton("Female");
        radioFemale.setBounds(150,150,100,30);
        frame.add(radioFemale);

        JRadioButton radioMale=new JRadioButton("Male");
        radioMale.setBounds(270,150,100,30);
        frame.add(radioMale);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(radioFemale);
        genderGroup.add(radioMale);

        JLabel course=new JLabel("Course");
        course.setBounds(30,190,100,30);
        frame.add(course);

//      JCheckBox chkJava=new JCheckBox("Java");
//      chkJava.setBounds(150,190,100,30);
//      frame.add(chkJava);
//
//      JCheckBox chkPython=new JCheckBox("python");
//      chkPython.setBounds(150,220,100,30);
//      frame.add(chkPython);
//
//      JCheckBox chkC=new JCheckBox("C++");
//      chkC.setBounds(150,260,100,30);
//      frame.add(chkC);

        String[] courses = {"Select", "Java", "Python", "C++"};
        JComboBox<String> comboCourse = new JComboBox<>(courses);
        comboCourse.setBounds(150, 190, 150, 30);
        frame.add(comboCourse);

        JLabel lblFees=new JLabel("Fees");
        lblFees.setBounds(30,310,100,30);
        frame.add(lblFees);

        JTextField txtFees=new JTextField();
        txtFees.setBounds(150,310,100,30);
        frame.add(txtFees);

//        JLabel departmentLbl=new JLabel("Department");
//        departmentLbl.setBounds(30,350,100,30);
//        frame.add(departmentLbl);
//
//        String[] departmentList={"plz select","IT","SOD","Networks"};
//        JComboBox<String> departCombo=new JComboBox<>(departmentList);
//        departCombo.setBounds(150,350,100,30);
//        frame.add(departCombo);


        JCheckBox terms=new JCheckBox("Must be checked before saving");
        terms.setBounds(50,400,300,30);
        frame.add(terms);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(80, 450, 100, 30);
        frame.add(btnRegister);

        comboCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse=(String)comboCourse.getSelectedItem();
                if(selectedCourse.equals("Java")){
                    txtFees.setText("5000");
                } else if (selectedCourse.equals("Python")) {
                    txtFees.setText("450");

                } else if (selectedCourse.equals("C++")) {
                    txtFees.setText("400");
                }else {
                    txtFees.setText("");
                }
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!terms.isSelected()) {
                    JOptionPane.showMessageDialog(null, "you must accept terms and conditions");
                    return;


                }

                String firstName =txtName1.getText();
                String lastName=txtName2.getText();
                String dob = txtDate.getText();
                String selectedCourse=(String)comboCourse.getSelectedItem();
                String gender="";
                if(radioFemale.isSelected()){
                    gender="Female";
                }if(radioMale.isSelected()){
                    gender="Male";
                }
//                  String fees=txtFees.getText().trim();
                Double Fees=0.0;
                try {
                    Fees=Double.parseDouble(txtFees.getText());
                } catch (NumberFormatException ex) {
                    System.out.println("error "+ex.getMessage());
                }

                try {
                    SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
                    java.util.Date utilDate=sdf.parse(dob);
                    java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());

                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","system","12345");
                    String query="INSERT INTO try(firstName,lastName,dob,gender,course,fees) VALUES(?,?,?,?,?,?)";
                    PreparedStatement pst= conn.prepareStatement(query);
                    pst.setString(1,firstName);
                    pst.setString(2,lastName);
                    pst.setDate(3,sqlDate);
                    pst.setString(4,gender);
                    pst.setString(5,selectedCourse);
                    pst.setDouble(6,Fees);

                    pst.executeUpdate();
                    pst.close();
                    conn.close();
                    JOptionPane.showMessageDialog(frame,"data insetred successfully");



                } catch (SQLException ex) {
                    System.out.println("connection not established "+ex.getMessage());
                } catch (ParseException ex) {
                    System.out.println("date not done well "+ex.getMessage());
                }

                }

        });
        frame.setVisible(true);

    }
}
