package JAVA_HOMEWORK;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookstoreGUI extends JFrame {
    private JTable bookTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchButton, viewAllButton;

    public BookstoreGUI() {
        setTitle("Online Bookstore");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create Table Model (Initially Empty)
        tableModel = new DefaultTableModel(new String[]{"BOOK_ID", "TITLE", "AUTHOR", "PRICE", "STOCK"}, 0);
        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane, BorderLayout.CENTER);

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        viewAllButton = new JButton("View All");
        searchPanel.add(new JLabel("Search by Title or Author:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(viewAllButton);
        add(searchPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText().trim();
                loadBooks(keyword);
            }
        });

        // View all button action
        viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBooks(""); // Reload all books
            }
        });

        // Do not load books initially (table remains empty)
        setVisible(true);
    }

    private void loadBooks(String keyword) {
        tableModel.setRowCount(0); // Clear table
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM books WHERE TITLE LIKE ? OR AUTHOR LIKE ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "%" + keyword + "%");
                stmt.setString(2, "%" + keyword + "%");
                ResultSet rs = stmt.executeQuery();

                boolean hasResults = false;
                while (rs.next()) {
                    hasResults = true;
                    tableModel.addRow(new Object[]{
                            rs.getInt("BOOK_ID"),
                            rs.getString("TITLE"),
                            rs.getString("AUTHOR"),
                            rs.getDouble("PRICE"),
                            rs.getInt("STOCK")
                    });
                }

                if (!hasResults) {
                    JOptionPane.showMessageDialog(this, "No books found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookstoreGUI());
    }
}
