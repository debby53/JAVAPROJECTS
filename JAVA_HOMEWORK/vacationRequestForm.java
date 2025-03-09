package JAVA_HOMEWORK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vacationRequestForm {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Vacation Request Form");
        frame.setSize(700,700);

        frame.getContentPane().setBackground(new Color(211, 211, 211));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

//        1.labels

        JLabel lblInfo=new JLabel("Fill out the form below to request your vacation time");
        lblInfo.setBounds(30,30,200,40);
        frame.add(lblInfo);

        JLabel fName=new JLabel("First Name");
        fName.setBounds(50,60,100,30);
        frame.add(fName);

        JTextField txtName=new JTextField();
        txtName.setBounds(170,60,100,30);
        frame.add(txtName);

        JLabel lName=new JLabel("Last name");
        lName.setBounds(50,100,100,30);
        frame.add(lName);

        JTextField txtLName=new JTextField();
        txtLName.setBounds(170,100,100,30);
        frame.add(txtLName);

        JLabel emailAddress=new JLabel("Email Address");
        emailAddress.setBounds(50,140,100,30);
        frame.add(emailAddress);

        JTextField txtEmail=new JTextField();
        txtEmail.setBounds(170,140,100,30);
        frame.add(txtEmail);

        JLabel phone=new JLabel("Phone Number");
        phone.setBounds(50,180,100,30);
        frame.add(phone);

        JTextField txtPhone=new JTextField();
        txtPhone.setBounds(170,180,100,30);
        frame.add(txtPhone);

        JLabel department=new JLabel("Department");
        department.setBounds(50,220,100,30);
        frame.add(department);

        String[]departmentList={"select your department","HR","IT","Sales","Accounting","Finance"};
        JComboBox<String> departCombo=new JComboBox<>(departmentList);
        departCombo.setBounds(170,220,200,30);
        frame.add(departCombo);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(50,260,100,30);
        frame.add(gender);

        JRadioButton radioFemale=new JRadioButton("Female");
        radioFemale.setBounds(170,260,100,30);
        frame.add(radioFemale);

        JRadioButton radioMale=new JRadioButton("Male");
        radioMale.setBounds(280,260,100,30);
        frame.add(radioMale);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(radioFemale);
        genderGroup.add(radioMale);


        JLabel startDate=new JLabel(" Vacation Start Date");
        startDate.setBounds(50,300,200,30);
        frame.add(startDate);

        JTextField txtFDate=new JTextField();
        txtFDate.setBounds(190,300,100,30);
        frame.add(txtFDate);

        JLabel endDate=new JLabel(" Vacation end Date");
        endDate.setBounds(350,300,200,30);
        frame.add(endDate);

        JTextField txtLDate=new JTextField();
        txtLDate.setBounds(500,300,100,30);
        frame.add(txtLDate);

        JLabel vacationType=new JLabel("Vacation Type");
        vacationType.setBounds(50,340,100,30);
        frame.add(vacationType);

        JCheckBox paid=new JCheckBox("paid  Time off");
        paid.setBounds(170,340,150,30);
        frame.add(paid);

        JCheckBox sickLeave=new JCheckBox("sick leave");
        sickLeave.setBounds(170,380,150,30);
        frame.add(sickLeave);

        JCheckBox unPaid=new JCheckBox("unpaid  Time off");
        unPaid.setBounds(170,420,150,30);
        frame.add(unPaid);

        JLabel comment=new JLabel("Reason for vacation");
        comment.setBounds(30,500,250,30);
        frame.add(comment);

        JTextField txtComment=new JTextField();
        txtComment.setBounds(170,500,400,40);
        frame.add(txtComment);

        JCheckBox confirm=new JCheckBox("Confirm");
        confirm.setBounds(350,570,80,30);
        frame.add(confirm);

        JButton submit=new JButton("Submit");
        submit.setBounds(460,570,80,30);
        frame.add(submit);


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName=txtName.getText();
                String lastName=txtLName.getText();
                String email1=txtEmail.getText();
                String telephone=txtPhone.getText();
                String depart1=(String) departCombo.getSelectedItem();
                String rsn=txtComment.getText();
                String startDate1=txtFDate.getText();
                String endDate1=txtLDate.getText();

                String gender1="";
                if(radioFemale.isSelected()){
                    gender1="Female";
                }
                if (radioMale.isSelected()){
                    gender1="Male";
                }

                String type="";
                if(paid.isSelected()){
                    type+="Paid Time off";
                }
                if (sickLeave.isSelected()){
                    type+="Sick leave";
                }
                if(unPaid.isSelected()){
                    type+="unpaid time off";
                }

                if(firstName.isEmpty() || lastName.isEmpty() || email1.isEmpty() || depart1.isEmpty() || gender1.isEmpty()|| startDate1.isEmpty() || endDate1.isEmpty() || type.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill all the information ", "Error ",JOptionPane.ERROR_MESSAGE);
                } else if (!email1.contains("@")) {
                    JOptionPane.showMessageDialog(null,"please use proper email format", "Error",JOptionPane.ERROR_MESSAGE);

                } else if (!telephone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(null,"Please phone number must be 10 letters","Error ",JOptionPane.ERROR_MESSAGE);

                }else {
                    JOptionPane.showMessageDialog(null,"Submitted successfully! \n " + "First Name\n "+ firstName + "Last Name\n "+lastName + "Email Address\n "+email1 + "Phone number\n "+ telephone + " Department\n "+ depart1 + "Gender\n "+ gender1 + "Vacation Start Date\n "+startDate1 + "Vacation end Date\n "+ endDate1 + "Vacation Type\n "+ type + "Reason for vacation "+ rsn);
                }
            }
        });











        frame.setVisible(true);


    }
}
