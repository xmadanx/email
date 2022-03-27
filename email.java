import java.io.*;
import java.lang.*;
import java.util.*;
import java.sql.*;

public class email {
    public static void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Username");
        String username = sc.nextLine();
        System.out.println("Enter your Password");
        String password = sc.nextLine();

        String url="jdbc:mysql://localhost:3306/email";
        String user="root";
        String pass="";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, user, pass);
            Statement s = c.createStatement();
            String q = "insert into user values('" + username + "','" + password + "')";
            s.executeUpdate(q);
            System.out.println("Signup Successful");
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        } 
        
    }
    public static void main(String[] args) {
        signup();
    }
}