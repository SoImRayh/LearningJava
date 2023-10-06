package dev.rayh.apps;

import java.util.*;
import java.util.function.Function;

public class FunctionArray {

    //funções que exigem entrada e possuem return
    static Function<Double, Double> f = (val) -> val * 2;

    static int direcao = 0;

    //array de funções void
    static List<Runnable> array = new ArrayList<>(List.of(
            () -> {
                direcao = 1;
                System.out.println(direcao);
            },
            () -> {
                direcao = 2;
                System.out.println(direcao);
            },() -> {
                direcao = 3;
                System.out.println(direcao);
            },() -> {
                direcao = 4;
                System.out.println(direcao);
            }
    ));

    public static void main(String[] args) {

        array.forEach(Runnable::run);

    }
}
