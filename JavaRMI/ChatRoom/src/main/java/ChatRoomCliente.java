import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import domain.Chat;

public class ChatRoomCliente {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        try{

        domain.Chat chat = (Chat) Naming.lookup("rmi://localhost:8080/chat");

        String message = "";
        boolean controle = true;

        while( controle ){
            message = scanner.nextLine();
            if  (message.equals("exit()")){
                controle = false;
            }else{
                chat.addMessage(message);
            }
        }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            System.out.println("nada");
        }
    }
}
