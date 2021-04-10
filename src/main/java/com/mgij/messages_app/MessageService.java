package com.mgij.messages_app;

import java.sql.SQLException;
import java.util.Scanner;

public class MessageService {
    public static void addMessage() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the message");
        String message = sc.nextLine();

        System.out.println("Who are you?");
        String author = sc.nextLine();

        Message row = new Message();
        row.setMessage(message);
        row.setAuthor(author);

        MessageDAO.addMessage(row);
    }

    public static void getMessages() throws SQLException {
        MessageDAO.getMessages();
    }

    public static void deleteMessage(){

    }

    public static void updateMessage(){

    }
}
