

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import domain.Chat;
import domain.impl.ChatImpl;

public class ChatRoomServidor {
    public static void main(String[] args) {
        try{
            Chat chat = new ChatImpl();

        Registry registry = LocateRegistry.createRegistry(8080);
        Naming.rebind("rmi://localhost:8080/chat", chat);
        }catch( RemoteException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
