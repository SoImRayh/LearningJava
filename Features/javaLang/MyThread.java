package javaLang;

public class MyThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.printf("%s is runing", name);
        };

        Thread thread = new Thread( runnable, "A nossa thread" );
        thread.start();
    }
}
