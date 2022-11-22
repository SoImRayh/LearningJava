package poo2022;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            Mews.codigo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
