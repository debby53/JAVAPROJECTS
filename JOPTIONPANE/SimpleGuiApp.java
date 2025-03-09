package JOPTIONPANE;


import javax.swing.*;

//a java program to add 2 numbers by using JPTIONPane class
public class SimpleGuiApp {
    public static void main(String[] args) {
        int num1,num2,sum;
        String number1,number2;
//        JOptionPane.showMessageDialog(null,"Enter the first number");
        number1=JOptionPane.showInputDialog("enter the first number:");
        number2=JOptionPane.showInputDialog("Enter the second number:");
        num1=Integer.parseInt(number1);
        num2=Integer.parseInt(number2);
        sum=num1+num2;
        JOptionPane.showMessageDialog(null,"the sum is "+sum,"Result",JOptionPane.INFORMATION_MESSAGE);



    }
}
