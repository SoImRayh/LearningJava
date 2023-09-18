import rmi.objects.Calculadora;
import rmi.objects.impl.CalculadoraImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            Calculadora calculadora =new CalculadoraImpl();

            //criando um registry na porta especificada
            Registry registry = LocateRegistry.createRegistry(8080);

            Naming.rebind("rmi://localhost:8080/calc", calculadora);

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
