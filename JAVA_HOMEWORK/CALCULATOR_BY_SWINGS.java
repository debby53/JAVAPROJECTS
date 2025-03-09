package JAVA_HOMEWORK;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CALCULATOR_BY_SWINGS {
    public static void main(String[] args) {
        JFrame frame=new JFrame("SIMPLE CALCULATOR");
        frame.setSize(1000,1000);
        JLabel lblNum1=new JLabel("first Number");
        JLabel lblNum2=new JLabel("second Number");
        JLabel lblResult=new JLabel();
        JLabel lblAnswer=new JLabel("Result");

        JTextField txtNum1=new JTextField();
        JTextField txtNum2=new JTextField();

        JButton btnAdd=new JButton("+");
        JButton btnSub=new JButton("-");
        JButton btnMulti=new JButton("*");
        JButton btnDiv=new JButton("/");
        JButton btnClear=new JButton("clear");

        lblNum1.setBounds(100,50,150,30);
        txtNum1.setBounds(270,50,150,30);
        lblNum2.setBounds(100,100,150,30);
        txtNum2.setBounds(270,100,150,30);
        lblAnswer.setBounds(100,150,150,30);
        lblResult.setBounds(270,150,150,30);

        btnAdd.setBounds(200,250,100,30);
        btnSub.setBounds(320,250,100,30);
        btnMulti.setBounds(440,250,100,30);
        btnDiv.setBounds(560,250,100,30);
        btnClear.setBounds(680,250,100,30);

        frame.setLayout(null);
        frame.add(lblNum1);
        frame.add(lblNum2);
        frame.add(txtNum1);
        frame.add(txtNum2);
        frame.add(lblAnswer);
        frame.add(lblResult);
        frame.add(btnAdd);
        frame.add(btnDiv);
        frame.add(btnClear);
        frame.add(btnSub);
        frame.add(btnMulti);
        frame.setVisible(true);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1,num2,result;
                try {
                    num1=Double.parseDouble(txtNum1.getText());
                    num2=Double.parseDouble(txtNum2.getText());
                    result=num1+num2;
                    lblResult.setText(String.valueOf(result));
                }catch (NumberFormatException ex){
                    lblResult.setText("invalid input!");
                }

            }
        });
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1,num2,result;
                try {
                    num1=Double.parseDouble(txtNum1.getText());
                    num2=Double.parseDouble(txtNum2.getText());
                    result=num1-num2;
                    lblResult.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    lblResult.setText("invalid input!");
                }
            }
        });

        btnMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1,num2,result;
                try {
                    num1 = Double.parseDouble(txtNum1.getText());
                    num2 = Double.parseDouble(txtNum2.getText());
                    result = num1 * num2;
                    lblResult.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    lblResult.setText("Invalid input!");

                }

            }
        });

        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1, num2, result;
                try {
                    num1 = Double.parseDouble(txtNum1.getText());
                    num2 = Double.parseDouble(txtNum2.getText());
                    if(num2==0){
                        lblResult.setText("cannot divide by 0");
                    }else {
                        result=num1/num2;
                        lblResult.setText(String.valueOf(result));
                    }

                }catch (NumberFormatException ex){
                    lblResult.setText("invalid input!");
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNum1.setText("");
                txtNum2.setText("");
                lblResult.setText("");
            }
        });







    }
}
