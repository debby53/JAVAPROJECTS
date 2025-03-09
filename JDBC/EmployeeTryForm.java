package JDBC;

import java.sql.*;

public class EmployeeTryForm {
    public static void main(String[] args) {
     String dbURL ="jdbc:oracle:thin:@//localhost:1522/orcl";
     String username="system";
     String password="12345";

     try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn= DriverManager.getConnection(dbURL,username,password);
         Statement stm=conn.createStatement();
         String sql="SELECT e.id,e.firstname,e.lastname,e.age ,s.NET_SALARY from " +
                 "wedEmployee e  " +
                 "JOIN wedSalary s ON e.id=s.employee_id " +
                 "where e.age>=55 and s.NET_SALARY<500000 ";
         ResultSet rs=stm.executeQuery(sql);

         while(rs.next()){
             int age=rs.getInt("age");
             int id=rs.getInt("id");
             String firstName=rs.getString("firstname");
             String lastName=rs.getString("lastname");
             int netSalary=rs.getInt("NET_SALARY");
//             String phone=rs.getString("phone ");
//             String email=rs.getString("Email");
//             int ssn=rs.getInt("ssn");
//             String gender=rs.getString("gender");
//             String department=rs.getString("department");
//             String hobbies=rs.getString("hobbies");
//

             System.out.println("first name "+firstName);
             System.out.println("second name "+lastName);
             System.out.println("id "+id);
             System.out.println("age "+age);
//             System.out.println(" phone "+phone);
//             System.out.println("email "+email);
//             System.out.println("ssn "+ssn);
//             System.out.println("gender "+gender);
//             System.out.println("department "+department);
//             System.out.println("hobbies "+hobbies);
             System.out.println("------------------");
         }
     } catch (ClassNotFoundException e) {
         System.out.println("Failed to Register JDBC Driver ::::: "+e.getMessage());
     } catch (SQLException e) {
         System.out.println("data base error "+ e.getMessage());

     }
    }

}
