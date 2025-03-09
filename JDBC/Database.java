package JDBC;

import java.sql.*;

public class Database {
    public static void main(String[] args) {
        String dbUrl="jdbc:oracle:thin:@//localhost:1522/orcl";

        String username="system";
        String password="12345";

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(dbUrl,username,password);
            Statement stm= conn.createStatement();
            String sql=" SELECT e.id,firstname,lastname,age,NET_SALARY " +
                    "from wedEmployee e "+
                    "JOIN wedSalary s ON e.id=s.employee_id " +
                    "where s.NET_SALARY =(" +
                    "SELECT MAX(s2.NET_SALARY) " +
                    "FROM  wedSalary s2 " +
                    "JOIN wedEmployee e2 ON e2.id=s2.employee_id WHERE e2.department =e.department " +
                    ") " +
                    "ORDER BY e.department";
            ResultSet rs=stm.executeQuery(sql);
            while ((rs.next())){
                int id=rs.getInt("id");
                String fName=rs.getString("firstname");
                String lName=rs.getString("lastname");
                int age = rs.getInt("age");
                double netSalary = rs.getDouble("NET_SALARY");


                System.out.println("Employee ID: " + id);
                System.out.println("First Name: " + fName);
                System.out.println("Last Name: " + lName);
                System.out.println("Age: " + age);
                System.out.println("Net Salary: " + netSalary);
                System.out.println("-----------------------------");

            }
        } catch (ClassNotFoundException e) {
            System.out.println("failed to register jdbc driver "+e.getMessage());
        } catch (SQLException e) {
            System.out.println("database error "+e.getMessage());
        }


    }
}
