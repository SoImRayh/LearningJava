package dev.rayh.domain;

import java.net.ServerSocket;

public class ChatServer {
    ServerSocket serverSocket;

    public ChatServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Chat server started on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
