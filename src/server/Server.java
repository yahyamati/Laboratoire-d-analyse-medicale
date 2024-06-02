package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loukmane04
 */
public class Server {
    static final int Port = 9090;
    
    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        ServerSocket listener = new ServerSocket(Port);
        final String DB_URL = "jdbc:mysql://localhost:3306/laboratoire_d_analyse?useSSL=false";// the data base URL
        final String USER = "root";
        final String PASS = ""; // No password is typically set in XAMPP by default

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("helloo");
            System.out.println("Connected to database");
            while(true){
                System.out.println("[Server ] is waitnig for the client....");
                 Socket client =  listener.accept();
                System.out.println("[Server] connects to the client ");
                ClientHandler clientHandler = new ClientHandler(client , conn);
                new Thread(clientHandler).start();
        }
        } catch (SQLException e) {
        }
    }
   
}
