package JDBC;

import java.sql.*;

public class BooksRetrieval {
    public static void main(String[] args) {
        String dbUrl="jdbc:oracle:thin:@//localhost:1522/orcl";
        String username="system";
        String password="12345";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(dbUrl,username,password);
            Statement stm= conn.createStatement();
            String sql="SELECT BOOK_ID,TITLE,AUTHOR,PRICE,STOCK FROM BOOKS";
            ResultSet rs= stm.executeQuery(sql);

            while (rs.next()){
                int id=rs.getInt("BOOK_ID");
                String title=rs.getString("TITLE");
                String author=rs.getString("AUTHOR");
                double price=rs.getDouble("PRICE");
                double stock= rs.getDouble("STOCK");


                System.out.println("book id "+id);
                System.out.println("title "+ title);
                System.out.println("author "+author);
                System.out.println("price "+price);
                System.out.println("stock "+stock);
                System.out.println("_____---------------");
            }


        } catch (ClassNotFoundException e) {
            System.out.println("class not found" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("not connected "+e.getMessage());
        }

    }
}
