package com.mgij.messages_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {
    public static void addMessage(Message message) throws SQLException {
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        try{
            PreparedStatement ps = null;
            String query = "INSERT INTO messages (message, author) VALUES (?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getAuthor());
            ps.executeUpdate();
            System.out.println("The message was created");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void getMessages() throws SQLException {
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT * FROM messages";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Id: " + rs.getInt("id"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Date: " + rs.getString("date"));
                System.out.println("---------");
            }
        }catch (SQLException e){
            System.out.println("Messages not recoverable");
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMessage(int id) throws SQLException {
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        try {
            PreparedStatement ps = null;
            String query = "DELETE FROM messages WHERE id = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int countRowsAffected = ps.executeUpdate();
            if(countRowsAffected > 0){
                System.out.println("The message has been deleted successfully");
            }else{
                System.out.println("The message wasn't found");
            }

        }catch (SQLException e){
            System.out.println("The message couldn't be deleted");
            System.out.println(e.getMessage());
        }
    }

    public static void updateMessage(Message message){

    }
}
