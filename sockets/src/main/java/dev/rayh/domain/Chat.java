package dev.rayh.domain;

import java.net.Socket;
import java.util.List;
import java.util.Map;

public class Chat {
    private List<Map<String, String>> messages;
    private List<Socket> clients;

    public Chat(){
        this.messages = new java.util.ArrayList<>();
        this.clients = new java.util.ArrayList<>();
    }

    public void addMessage(String sender, String message){
        messages.add(Map.of("sender", sender, "message", message));
    }

    private void notifyClients(String message){
        for(Socket client : clients){
            try {
                var out = new java.io.PrintWriter(client.getOutputStream(), true);
                out.println(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
