package JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_swing {
    public static void main(String[] args) {
        JFrame frame=new JFrame("SIMPLE CALCULATOR");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        JLabel lblNum1=new JLabel("number 1");
        lblNum1.setBounds(30,30,100,30);
        frame.add(lblNum1);

        JTextField txtNum1=new JTextField();
        txtNum1.setBounds(150,30,100,30);
        frame.add(txtNum1);


        JLabel lblNum2=new JLabel("number 2");
        lblNum2.setBounds(30,80,100,30);
        frame.add(lblNum2);

        JTextField txtNum2=new JTextField();
        txtNum2.setBounds(150,80,100,30);
        frame.add(txtNum2);

        JLabel opera=new JLabel("Operation");
        opera.setBounds(30,130,100,30);
        frame.add(opera);

        JLabel result=new JLabel("Result");
        result.setBounds(30,180,100,30);
        frame.add(result);

        JTextField txtResult=new JTextField();
        txtResult.setBounds(150,180,100,30);
        frame.add(txtResult);

        String[] operations={"select","+","-","*","/"};
        JComboBox<String> comboOperation=new JComboBox<>(operations);
        comboOperation.setBounds(150,130,100,30);
        frame.add(comboOperation);

        JButton btnCalc=new JButton("CALCULATE");
        btnCalc.setBounds(200,230,100,30);
        frame.add(btnCalc);

        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double num1=Double.parseDouble(txtNum1.getText());
                double num2=Double.parseDouble(txtNum2.getText());
                double result=0.0;
                String ops=(String)comboOperation.getSelectedItem();;
                switch (ops){
                    case "+":
                        result=num2+num1;
                        break;
                    case "-":
                        result=num1-num2;
                        break;

                    case "*":
                        result=num2*num1;
                        break;
                    case "/":
                        if(num2==0){
                            JOptionPane.showMessageDialog(null,"number 2 must be different from 0");
                            txtResult.setText("");
                        }else {
                            result=num1/num2;
                        }

                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"INVALID CHOICE.TRY AGAIN");
                        break;





                }
                txtResult.setText(String.valueOf(result));

            }
        });




        frame.setVisible(true);
    }
}
