package dev.rayh;

import dev.rayh.domain.ChatServer;

public class Servermain {
    public static void main(String[] args) {
        int port = 12345;
        ChatServer server = new ChatServer(port);
    }
}