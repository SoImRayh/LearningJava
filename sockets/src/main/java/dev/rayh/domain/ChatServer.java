package dev.rayh.domain;

import java.net.ServerSocket;
import java.util.List;

import dev.rayh.console.ConsolePrinter;

public class ChatServer {
    
    ServerSocket serverSocket;
    Chat chat = new Chat();

    public ChatServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            ConsolePrinter.INFO("ChatServer", "Server started on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            while (true) {
                // Wait for a client to connect
                ConsolePrinter.INFO("ChatServer", "Waiting for clients to connect...");
                var clientSocket = serverSocket.accept();
                ConsolePrinter.INFO("ChatServer", "Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Handle the client connection in a new thread
                new Thread(new ClientHandler(clientSocket, chat)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
