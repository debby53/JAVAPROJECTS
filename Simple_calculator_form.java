import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simple_calculator_form {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null , "welcome to a simple calculator");
        JFrame frame=new JFrame("SIMPLE CALCULATOR");
        frame.setSize(600,500);
        frame.setResizable(true);
        JLabel lblNum1=new JLabel("First number");
        JLabel lblNum2=new JLabel("second number");
        JLabel lblResult=new JLabel();
        JLabel lblAnswer=new JLabel("Result ");
        JTextField txtNum1=new JTextField();
        JTextField txtNum2=new JTextField();

        JButton btnAdd=new JButton("+");
        JButton btnSub=new JButton("-");
        JButton btnMulti=new JButton("*");
        JButton btnDiv=new JButton("/");
        JButton btnClear = new JButton("Clear");

        lblNum1.setBounds(50,50,100,40);
        txtNum1.setBounds(170,50,100,40);
        lblNum2.setBounds(50,110,100,40);
        txtNum2.setBounds(170,110,100,40);
        lblAnswer.setBounds(50,170,100,40);
        lblResult.setBounds(170,170,100,40);
        btnAdd.setBounds(100,200,80,60);
        btnSub.setBounds(190,200,80,60);
        btnMulti.setBounds(280,200,80,60);
        btnDiv.setBounds(370,200,80,60);
        btnClear.setBounds(230, 320, 100, 50);

        frame.setLayout(null);
        frame.add(lblNum1);
        frame.add(txtNum1);
        frame.add(lblNum2);
        frame.add(txtNum2);
        frame.add(lblAnswer);
        frame.add(lblResult);
        frame.add((btnAdd));
        frame.add(btnSub);
        frame.add(btnMulti);
        frame.add(btnDiv);
        frame.add(btnClear);
        frame.setVisible(true);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1,num2,result;
                num1=Integer.parseInt(txtNum1.getText());
                num2=Integer.parseInt(txtNum2.getText());
                result=num1+num2;
                lblResult.setText(result +"");
            }
        });
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1,num2,result;
                num1=Integer.parseInt(txtNum1.getText());
                num2=Integer.parseInt(txtNum2.getText());
                result=num1-num2;
                lblResult.setText(result +"");
            }
        });
        btnMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1,num2,result;
                num1=Integer.parseInt(txtNum1.getText());
                num2=Integer.parseInt(txtNum2.getText());
                result=num1*num2;
                lblResult.setText(result + "");
            }
        });
        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1,num2,result;
                num1=Integer.parseInt(txtNum1.getText());
                num2=Integer.parseInt(txtNum2.getText());
                result=num1/num2;
                lblResult.setText(result + "");
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
