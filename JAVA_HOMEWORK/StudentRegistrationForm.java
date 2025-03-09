package JAVA_HOMEWORK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm {
    public static void main(String[] args) {
//        creation of a frame
        JFrame frame=new JFrame("STUDENT REGISTRATION FORM");
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(227,242,253));
        frame.setLayout(null);
        JOptionPane.showMessageDialog(null,"WELCOME TO STUDENT REGISTRATION FORM ");


//        components
//        1. NAMES
        JLabel fName=new JLabel("First Name");
        fName.setBounds(30,30,100,30);
        frame.add(fName);

        JTextField txtFName=new JTextField();
        txtFName.setBounds(150,30,100,30);
        frame.add(txtFName);

        JLabel lName=new JLabel("Last Name");
        lName.setBounds(30,70,100,30);
        frame.add(lName);

        JTextField txtLName=new JTextField();
        txtLName.setBounds(150,70,100,30);
        frame.add(txtLName);

//        2.AGE
        JLabel age=new JLabel("Age");
        age.setBounds(30,110,100,30);
        frame.add(age);

        JTextField txtAge=new JTextField();
        txtAge.setBounds(150,110,100,30);
        frame.add(txtAge);

//        3.GENDER
        JLabel gender =new JLabel("Gender");
        gender.setBounds(30,150,100,30);
        frame.add(gender);

        JRadioButton radioFemale=new JRadioButton("Female");
        radioFemale.setBounds(150,150,100,30);
        frame.add(radioFemale);

        JRadioButton radioMale=new JRadioButton("Male");
        radioMale.setBounds(300,150,100,30);
        frame.add(radioMale);

        JRadioButton radioOther=new JRadioButton("Other");
        radioOther.setBounds(450,150,100,30);
        frame.add(radioOther);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(radioFemale);
        genderGroup.add(radioMale);
        genderGroup.add(radioOther);

//        JPanel genderPanel=new JPanel();
//        genderPanel.setBounds(150, 150, 400, 40);
//        genderPanel.add(radioOther);
//        genderPanel.add(radioFemale);
//        genderPanel.add(radioMale);
//        frame.add(genderPanel);


//   5. DEPARTMENT
        JLabel department=new JLabel("Department");
        department.setBounds(30,190,100,30);
        frame.add(department);

      String[]departmentList={ " select  department","IT","Finance","Marketing","Engineering"};
      JComboBox<String>comboDepartment=new JComboBox<>(departmentList);
      comboDepartment.setBounds(150,190,150,30);
      frame.add(comboDepartment);

//      6. COURSE
        JLabel course=new JLabel("Course");
        course.setBounds(30,230,100,30);
        frame.add(course);

        String[]coursesList={"select courses","Computer Science", "Software Engineering", "Electrical Engineering", "Business Administration"};
        JComboBox<String>comboCourses=new JComboBox<>(coursesList);
        comboCourses.setBounds(150,230,150,30);
        frame.add(comboCourses);

//        7.Email
        JLabel email=new JLabel("Email");
        email.setBounds(30,270,100,30);
        frame.add(email);

        JTextField txtEmail=new JTextField();
        txtEmail.setBounds(150,270,100,30);
        frame.add(txtEmail);


//        8.Password
        JLabel password=new JLabel("password");
        password.setBounds(30,310,100,30);
        frame.add(password);

        JPasswordField passField=new JPasswordField();
        passField.setBounds(150,310,100,30);
        frame.add(passField);

//        9.phone number

        JLabel phone=new JLabel("Phone Number");
        phone.setBounds(30,350,100,30);
        frame.add(phone);

        JTextField txtPhone=new JTextField();
        txtPhone.setBounds(150,350,100,30);
        frame.add(txtPhone);

//      10.  skills
        JLabel skills =new JLabel("Skills");
        skills.setBounds(30,390,100,30);
        frame.add(skills);

        JCheckBox chkJava=new JCheckBox("Java");
        chkJava.setBounds(150,390,100,30);
        frame.add(chkJava);

        JCheckBox python=new JCheckBox("Python");
        python.setBounds(150,430,100,30);
        frame.add(python);

        JCheckBox other=new JCheckBox("Other");
        other.setBounds(150,470,100,30);
        frame.add(other);


//    11.Additional Comments
        JLabel comments=new JLabel("Additional Comments");
        comments.setBounds(30,510,100,30);
        frame.add(comments);

        JTextField txtComments=new JTextField();
        txtComments.setBounds(150,510,300,60);
        frame.add(txtComments);
//        12.buttons

        JButton submit=new JButton("Submit");
        submit.setBounds(150,600,80,30);
        frame.add(submit);

        JButton reset=new JButton("Reset");
        reset.setBounds(300,600,80,30);
        frame.add(reset);



//        actionLister
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName=txtFName.getText();
                String lastName=txtLName.getText();




               String age = txtAge.getText();



                String genders="";
                if(radioFemale.isSelected()){
                    genders="Female";
                }if (radioMale.isSelected()){
                    genders="Male";
                }if (radioOther.isSelected()){
                    genders="Others";
                }
                String studentEmail=txtEmail.getText();
                String comment=txtComments.getText();
                String StdPhone=txtPhone.getText();
                String passwd=new String(passField.getPassword());
                String course=(String) comboCourses.getSelectedItem();
                String depart=(String) comboDepartment.getSelectedItem();

                String skill="";
                if (chkJava.isSelected()){
                    skill+="java";

                }if(python.isSelected()){
                    skill=skill + "python";
                }if (other.isSelected()){
                    skill+="others";
                }
//                VALIDATIONS

                if(firstName.isEmpty() || lastName.isEmpty() || studentEmail.isEmpty() || StdPhone.isEmpty() || passwd.isEmpty() ){
                    JOptionPane.showMessageDialog(null," please fill all the fields ","error", JOptionPane.ERROR_MESSAGE);
                } else if (!studentEmail.contains("@")) {
                    JOptionPane.showMessageDialog(null,"Invalid email","Error",JOptionPane.ERROR_MESSAGE);
                    
                } else if (!StdPhone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(null,"Invalid Phone nbr ", "Error",JOptionPane.ERROR_MESSAGE);
                    
                } else if (passwd.length()<6) {
                    JOptionPane.showMessageDialog(null,"password must be at least 6 and above","Error",JOptionPane.ERROR_MESSAGE);
                    
                }else {
                    JOptionPane.showMessageDialog(null,"Registration Successful!\n" + "First Name: "+ firstName + "\nLast Name: "  + lastName + "\nAge: "+ age + " \nGender: " + genders + "\nCourse :" + course + "\nDepartment: "+depart + "\nEmail: " +studentEmail + "\nPhone Number:" + StdPhone + "\nSkills :" + skill + "\nComment: " + comment);

                }



            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFName.setText("");
                txtLName.setText("");
                txtAge.setText("");
                txtComments.setText("");
                txtEmail.setText("");
                txtPhone.setText("");
                passField.setText("");
                genderGroup.clearSelection();
                comboCourses.setSelectedIndex(0);
                comboDepartment.setSelectedIndex(0);
                chkJava.setSelected(false);
                python.setSelected(false);
                other.setSelected(false);
                comments.setText("");
            }
        });

        frame.setVisible(true);




    }
}
