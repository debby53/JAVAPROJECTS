package JAVA_PRACTICAL_QUESTIONS;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OnlineShoppingCartSystem {
    public static void main(String[] args) {
        JFrame frame =new JFrame(" Online Shopping Cart system");
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel lblName=new JLabel("Customer name");
        lblName.setBounds(30,30,100,30);
        frame.add(lblName);

        JTextField txtName=new JTextField();
        txtName.setBounds(150,30,100,30);
        frame.add(txtName);

        JLabel lblCategory=new JLabel("Product category");
        lblCategory.setBounds(30,70,100,30);
        frame.add(lblCategory);

        String[]productList={"Electronics", "Clothing", "Groceries"};
        JComboBox<String>productCombo=new JComboBox<>(productList);
        productCombo.setBounds(150,70,100,30);
        frame.add(productCombo);

        JLabel lblPName=new JLabel("Product Name");
        lblPName.setBounds(30,110,100,30);
        frame.add(lblPName);

        JTextField txtProductName=new JTextField();
        txtProductName.setBounds(150,110,100,30);
        frame.add(txtProductName);

        JLabel lblPrice=new JLabel("Price");
        lblPrice.setBounds(30,150,100,30);
        frame.add(lblPrice);

        JTextField txtPrice=new JTextField();
        txtPrice.setBounds(150,150,100,30);
        frame.add(txtPrice);

        JLabel lblQuantity=new JLabel("Quantity");
        lblQuantity.setBounds(30,190,100,30);
        frame.add(lblQuantity);

        JTextField txtQuantity=new JTextField();
        txtQuantity.setBounds(150,190,100,30);
        frame.add(txtQuantity);

        JLabel lblAmount=new JLabel("Total Amount");
        lblAmount.setBounds(30,220,100,30);
        frame.add(lblAmount);

        JTextField txtAmount=new JTextField();
        txtAmount.setBounds(150,220,100,30);
        frame.add(txtAmount);

        JButton order=new JButton("ORDER");
            order.setBounds(50,270,100,30);
            frame.add(order);

        DocumentListener updateTotalAmount = new DocumentListener() {
            public void update() {
                try {
                    int quantity = Integer.parseInt(txtQuantity.getText().trim());
                    double price = Double.parseDouble(txtPrice.getText().trim());
                    txtAmount.setText(String.valueOf(quantity * price));
                } catch (NumberFormatException ex) {
                    txtAmount.setText(""); // Clear if invalid input
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }
        };

        txtQuantity.getDocument().addDocumentListener(updateTotalAmount);
        txtPrice.getDocument().addDocumentListener(updateTotalAmount);

            order.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String customerName=txtName.getText();
                    String productName=txtProductName.getText();
                    String category=(String)productCombo.getSelectedItem();
                    int quantity = 0;
                    double price = 0.0;
                    double totalAmount = 0.0;
                    try {
                        quantity = Integer.parseInt(txtQuantity.getText());
                        price = Double.parseDouble(txtPrice.getText());
                        totalAmount = Double.parseDouble(txtAmount.getText());
                    } catch (NumberFormatException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }


                    try {
                        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","system","12345");
                        String query="INSERT INTO javaOrder(customerName,productCategory,ProductName,price,quantity,totalAmount)VALUES(?,?,?,?,?,?)";
                        PreparedStatement pst=conn.prepareStatement(query);
                        pst.setString(1,customerName);
                        pst.setString(2,category);
                        pst.setString(3,productName);
                        pst.setDouble(4,price);
                       pst.setInt(5,quantity);

                       pst.setDouble(6,totalAmount);
                       pst.executeUpdate();
                       pst.close();
                       conn.close();

                       JOptionPane.showMessageDialog(frame,"order saved successfully");

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error saving data." + ex.getMessage());
                    }
                }
            });






        frame.setVisible(true);
    }
}
