package JAVA_PRACTICAL_QUESTIONS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientManagementSystem {
    public static void main(String[] args) {

    JFrame frame=new JFrame(" Patient Management System");
    frame.setSize(500,500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);

    JLabel lblName=new JLabel("Patient Name");
    lblName.setBounds(30,30,100,30);
    frame.add(lblName);

    JTextField txtName=new JTextField();
    txtName.setBounds(150,30,100,30);
    frame.add(txtName);

    JLabel lblId=new JLabel("Patient ID ");
    lblId.setBounds(30,70,100,30);
    frame.add(lblId);

    JTextField txtId=new JTextField();
    txtId.setBounds(150,70,100,30);
    frame.add(txtId);

    JLabel lblDisease=new JLabel("Disease Type");
    lblDisease.setBounds(30,110,100,30);
    frame.add(lblDisease);

    String[]diseaseLists={"select","General Checkup"," Surgery", "Maternity"};
    JComboBox<String>comboType=new JComboBox<>(diseaseLists);
    comboType.setBounds(150,110,100,30);
    frame.add(comboType);

    JLabel lblDays=new JLabel("Days Admitted ");
    lblDays.setBounds(30,150,100,30);
    frame.add(lblDays);

    JTextField txtDays=new JTextField();
    txtDays.setBounds(150,150,100,30);
    frame.add(txtDays);

    JLabel lblInsurance=new JLabel("  have Health Insurance");
    lblInsurance.setBounds(30,190,100,30);
    frame.add(lblInsurance);

    JCheckBox chkYes=new JCheckBox("Yes");
    chkYes.setBounds(150,190,100,30);
    frame.add(chkYes);

    JCheckBox chkNo=new JCheckBox("No");
    chkNo.setBounds(150,230,100,30);
    frame.add(chkNo);

    JLabel lblBill =new JLabel("Total Bill");
    lblBill.setBounds(30,280,100,30);
    frame.add(lblBill);

    JTextField txtBill=new JTextField();
    txtBill.setBounds(150,280,100,30);
    frame.add(txtBill);

    JButton btnSubmit=new JButton("SUBMIT");
    btnSubmit.setBounds(80,320,100,30);
    frame.add(btnSubmit);


    btnSubmit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name=txtName.getText();
           String id=txtId.getText();
            String diseaseType=(String)comboType.getSelectedItem();

           boolean hasInsurance=chkYes.isSelected();
            int days=Integer.parseInt(txtDays.getText());
            double totalBill=0.0;
            double treatmentCost=0.0;

            if(diseaseType.equals("General Checkup")){
             treatmentCost=100;
            } else if (diseaseType.equals("Surgery")) {
               treatmentCost=3000;

            } else if (diseaseType.equals("Maternity")) {
                treatmentCost = 2000;
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a disease type.");
                return;
            }
            if(days>1){
                treatmentCost+=(days-1)*50;
            }
            if(hasInsurance){
               totalBill= treatmentCost*0.7;
            }else {
                totalBill=treatmentCost;
            }
            txtBill.setText(String.valueOf(totalBill));

            try{
                Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","system","12345");
                String query="INSERT INTO javaPatients(patientName,patientId,diseaseType,haveInsurance,daysAdmitted,totalBill)VALUES(?,?,?,?,?,?)";
                PreparedStatement pst= conn.prepareStatement(query);
                pst.setString(1,name);
                pst.setString(2,id);
                pst.setString(3,diseaseType);
                pst.setInt(4,days);
                pst.setBoolean(5,hasInsurance);
                pst.setDouble(6, totalBill);
                pst.executeUpdate();
                pst.close();
                conn.close();
                JOptionPane.showMessageDialog(frame, "Patient data saved successfully.");


            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame,ex.getMessage());
            }


        }
    });




    frame.setVisible(true);
    }

}
