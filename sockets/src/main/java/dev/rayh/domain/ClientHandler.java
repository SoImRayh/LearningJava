package dev.rayh.domain;

public class ClientHandler implements Runnable {
    private  java.net.Socket clientSocket;
    private  Chat chat;

    public ClientHandler(java.net.Socket clientSocket, Chat chat) {
        this.clientSocket = clientSocket;
        this.chat = chat;
    }

    @Override
    public void run() {
        try (var in = new java.io.BufferedReader(new java.io.InputStreamReader(clientSocket.getInputStream()));
             var out = new java.io.PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received from client: " + message);
                out.println("Echo: " + message); // Echo the message back to the client
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
