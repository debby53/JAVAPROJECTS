package JDBC;

import java.sql.*;

public class Java {
    public static void main(String[] args) {
        String dbUrl="jdbc:oracle:thin:@//localhost:1522/orcl";
        String username="system";
        String password="12345";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(dbUrl,username,password);
            Statement stm = conn.createStatement();
            String sql="SELECT name,salary FROM java";
            ResultSet rs= stm.executeQuery(sql);

            while (rs.next()){
                String name=rs.getString("name");
                Double salary=rs.getDouble("salary");

                System.out.println("name "+name);
                System.out.println("salary "+salary);

                System.out.println("name "+name);
                System.out.println("salary "+salary);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("class not found "+e.getMessage());
        } catch (SQLException e) {
            System.out.println("connection not established "+e.getMessage());

        }
    }
}
