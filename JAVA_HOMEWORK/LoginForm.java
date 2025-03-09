package JAVA_HOMEWORK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    static  final String DB_URL ="jdbc:oracle:thin:@localhost:1522:orcl";
    static  final String DB_USER ="system";
    static final  String DB_PASSWORD = "12345";
    public static void main(String[] args) {
//        create a frame
        JFrame frame=new JFrame("LOGIN FORM");
        frame.setSize(700,400);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(137,137,137));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JLabel userName=new JLabel(" username ");
        JLabel password=new JLabel(" password");
        JTextField txtName=new JTextField();
        JPasswordField txtPass=new JPasswordField();
        JButton log=new JButton("login");
        JButton clear=new JButton("clear");
        JLabel lblMessage = new JLabel("");

        userName.setBounds(100,50,150,30);
        txtName.setBounds(270,50,150,30);
        password.setBounds(100,100,150,30);
        txtPass.setBounds(270,100,150,30);
        log.setBounds( 150,140,100,30);
        clear.setBounds(270,140,100,30);
        lblMessage.setBounds(100, 200, 300, 30);


//     customise fonts and colors
        userName.setFont(new Font("Arial",Font.BOLD,14));
        password.setFont(new Font("Arial",Font.BOLD,14));
        lblMessage.setFont(new Font("Arial", Font.BOLD, 14));
        lblMessage.setForeground(Color.RED); // Error message in red

        log.setBackground(new Color(76,175,80));
        log.setForeground(Color.WHITE);
        clear.setBackground(new Color(240, 67, 54)); // Red button
        clear.setForeground(Color.WHITE);

//     // Add Components to Frame
        frame.setLayout(null);
        frame.add(userName);
        frame.add(password);
        frame.add(txtPass);
        frame.add(txtName);
        frame.add(log);
        frame.add(clear);
        frame.add(lblMessage);
        frame.setLocationRelativeTo(null);

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String name=txtName.getText();
               String password=new String(txtPass.getPassword());
               if(name.equals("java")&& password.equals("auca@123")){
                   lblMessage.setText("WELCOME TO JAVA");
                   lblMessage.setForeground(new Color(34, 139, 34));


               }else {
                   lblMessage.setText("Incorrect username/password. try again");
                   lblMessage.setForeground(Color.RED);
               }




            }
        });
clear.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        txtPass.setText("");
        txtName.setText("");
        lblMessage.setText("");
    }
});


 frame.setVisible(true);



    }
}
