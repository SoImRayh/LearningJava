
package domain;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * Chat
 */
public interface Chat extends Remote{

    List<String> getMessages() throws RemoteException;
    Boolean addMessage(String messsage) throws RemoteException;
}