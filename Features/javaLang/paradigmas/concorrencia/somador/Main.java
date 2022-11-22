package javaLang.paradigmas.concorrencia.somador;

public class Main {
    public static void main(String[] args) {
        MyObject eu = new MyObject("railande", 0);

        Runnable executar = new Somador(eu);

        // iniciando duas threads

        Thread th1 = new Thread(executar, "th1");
        Thread th2 = new Thread(executar, "th2");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}