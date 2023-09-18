package rmi.objects.impl;

import rmi.objects.Calculadora;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {


    public CalculadoraImpl() throws RemoteException{
        super();
    }

    @Override
    public int soma(int x, int y) throws RemoteException {
        return x+y;
    }

    @Override
    public int subtrair(int x, int y) throws RemoteException {
        return x-y;
    }

    @Override
    public BigInteger fatorial(int num) throws RemoteException {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= num; ++i) {
            factorial = factorial
                    .multiply(
                            BigInteger
                                    .valueOf(i));
        }
        return factorial;
    }

    @Override
    public String hello() throws RemoteException{
        return "hello world";
    }
}
