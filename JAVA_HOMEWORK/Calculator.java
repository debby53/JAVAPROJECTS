package JAVA_HOMEWORK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {

        JFrame frame=new JFrame("Simple calculator");
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245,245,245));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel lblNum1=new JLabel("First number");
        lblNum1.setBounds(30,30,100,30);
        frame.add(lblNum1);

        JTextField txtNum1=new JTextField();
        txtNum1.setBounds(150,30,100,30);
        frame.add(txtNum1);


        JLabel lblNum2=new JLabel("second number");
        lblNum2.setBounds(30,80,100,30);
        frame.add(lblNum2);

        JTextField txtNum2=new JTextField();
        txtNum2.setBounds(150,80,100,30);
        frame.add(txtNum2);

        String operations[]={ "select operations","+","-","*","/"};
        JComboBox<String>comboOperations=new JComboBox<>(operations);
        comboOperations.setBounds(30,130,140,30);
        frame.add(comboOperations);

        JButton btnCal=new JButton("Calculate ");
        btnCal.setBounds(150,250,100,30);
        frame.add(btnCal);



        JLabel lblResult=new JLabel("Result");
        lblResult.setBounds(30,180,100,30);
        frame.add(lblResult);

        JTextField txtResult=new JTextField();
        txtResult.setBounds(150,180,100,30);
        frame.add(txtResult);

        txtResult.setEditable(false);


        btnCal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    double result = 0.0;


                    String ops = (String) comboOperations.getSelectedItem();

                    switch (ops) {
                        case "+":
                            result = num1 + num2;
                            break;

                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":

                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                JOptionPane.showMessageDialog(null, "cannot divide a number by 0");

                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "THE OPERATION DOES NOT EXIST");
                            break;


                    }
                    txtResult.setText(String.valueOf(result));
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers");
                }
            }
        });

        frame.setVisible(true);

    }
}
