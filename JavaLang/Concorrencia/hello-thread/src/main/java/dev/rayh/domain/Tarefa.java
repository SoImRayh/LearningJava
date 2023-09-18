package dev.rayh.domain;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Tarefa implements Runnable{
    
    private int num;

    @Override
    public void run() 
    {
        so
        BigInteger fatorial= BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            fatorial = fatorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Fatorial : "+ fatorial);
    }

    
}
