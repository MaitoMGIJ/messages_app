package com.mgij.messages_app;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyConnection connection = new MyConnection();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        do{
            System.out.println("-----------------");
            System.out.println("Messages Application");
            System.out.println("1. Add Message");
            System.out.println("2. Get Message");
            System.out.println("3. Update Message");
            System.out.println("4. Delete Message");
            System.out.println("5. Exit");

            option = sc.nextInt();
            switch (option){
                case 1:
                    MessageService.addMessage();
                    break;
                case 2:
                    MessageService.getMessages();
                    break;
                case 3:
                    MessageService.updateMessage();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
                default:
                    break;
            }
        }while(option != 5);


        /*try(Connection cnx = connection.getConnection()){

        }catch (Exception e){
            System.out.println(e);
        }*/
    }
}
