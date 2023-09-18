package rmi.objects;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;

public interface Calculadora extends Remote {

    int soma (int x, int y) throws RemoteException;
    int subtrair (int x, int y) throws RemoteException;
    BigInteger fatorial( int num) throws RemoteException;
    String hello() throws RemoteException;
}
