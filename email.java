import java.io.*;
import java.lang.*;
import java.util.*;

import javax.sound.midi.Receiver;

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

    public static void compose() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the receiver's Username");
        String receiver = sc.nextLine();
        System.out.println("Enter the subject");
        String subject = sc.nextLine();
        System.out.println("Enter the message");
        String message = sc.nextLine();

        String mail = "From : " + receiver + "\n" + "Subject : " + subject + "\n" + "Message : " + message;

        String url="jdbc:mysql://localhost:3306/email";
        String user="root";
        String pass="";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, user, pass);
            Statement s = c.createStatement();
            String q = "insert into mail values('" + receiver + "','" + mail + "')";
            s.executeUpdate(q);
            System.out.println("Mail Sent");
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        public static void inbox() {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your Username");
            String username = sc.nextLine();
            System.out.println("Enter your Password");
            String password = sc.nextLine();

            //get all mails from database to inbox
            String url="jdbc:mysql://localhost:3306/email";
            String user="root";
            String pass="";

            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, user, pass);
            Statement s = c.createStatement();
            String q = "select * from mail where receiver='" + username + "'";
            ResultSet rs = s.executeQuery(q);
            while(rs.next()) {
                System.out.println(rs.getString(2));
            }
            c.close();
            } catch (Exception e) {
            System.out.println(e);
            }
        
    }
    public static void main(String[] args) {
        signup();
    }
}