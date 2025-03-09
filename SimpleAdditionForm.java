import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleAdditionForm {
    public static void main(String[] args) {
//       1. create a window by using JFrame
        JFrame frame=new JFrame("SIMPLE ADDITION FORM");
        frame.setSize(600,500);

        frame.setResizable(false); //make it not resizable
//       2. create Labels,textfields,buttons.....(Components)
        JLabel lblNum1=new JLabel("First number");
        JLabel lblNum2=new JLabel("Second number");
        JLabel lblSum=new JLabel("the sum:");
        JLabel lblResult=new JLabel();
        JTextField txtNum1=new JTextField();
        JTextField txtNum2=new JTextField();
        JButton btnAdd=new JButton("ADD");

        lblNum1.setBounds(100,50,150,30);
        txtNum1.setBounds(270,50,150,30);
        lblNum2.setBounds(100,100,150,30);
        txtNum2.setBounds(270,100,150,30);
        lblSum.setBounds(100,150,150,30);
        lblResult.setBounds(270,150,150,30);
        btnAdd.setBounds(250,210,100,30);
        frame.setLayout(null);
        frame.add(lblNum1);
        frame.add(txtNum1);
        frame.add(lblNum2);
        frame.add(txtNum2);
        frame.add(lblSum);
        frame.add(lblResult);
        frame.add(btnAdd);
        frame.setVisible(true); //make the frame visible
//        add action Lister to the button
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1,num2,result;
                num1=Integer.parseInt(txtNum1.getText());
                num2=Integer.parseInt(txtNum2.getText());
                result=num1+num2;
                lblResult.setText(result + "");
            }
        });

    }
}
