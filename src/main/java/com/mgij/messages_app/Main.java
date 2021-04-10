package com.mgij.messages_app;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        MyConnection connection = new MyConnection();
        try(Connection cnx = connection.getConnection()){

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
