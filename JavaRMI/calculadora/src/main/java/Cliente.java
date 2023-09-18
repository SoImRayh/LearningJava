import rmi.objects.Calculadora;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            // conectando com o objeto remoto
            Registry registry = LocateRegistry.getRegistry(null);
            Calculadora calculadora = (Calculadora) Naming.lookup("rmi://localhost:8080/calc");
            //===================================

            System.out.println(calculadora.hello());
            //UX:
            Scanner scanner = new Scanner(System.in);
            int numero = 1;

            while (numero != 0){
                System.out.print("insira o número a calcular o fatorial: ");

                numero = scanner.nextInt();
                if (numero != 0)
                    System.out.format("O Fatorial no número %d é: %d\n",numero, calculadora.fatorial(numero));
            }



        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}