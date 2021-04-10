package com.mgij.messages_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static void getMessages(){

    }

    public static void deleteMessage(int id){

    }

    public static void updateMessage(Message message){

    }
}
