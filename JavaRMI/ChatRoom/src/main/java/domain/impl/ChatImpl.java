package domain.impl;

import java.util.LinkedList;
import java.util.List;

import domain.Chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatImpl extends UnicastRemoteObject implements Chat {

    private List<String> messages;

    public ChatImpl() throws RemoteException{
        super();
        messages = new LinkedList<>();
    }

    public List<String> getMessages() throws RemoteException{
        return messages;
    };

    public Boolean addMessage(String message) throws RemoteException{
        messages.add(message);
        messages.forEach(msg -> {
            System.out.println(msg);
        });
        return true;
    };
    
}
