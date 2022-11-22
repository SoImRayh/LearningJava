package javaLang.paradigmas.concorrencia.somador;

import java.util.concurrent.Semaphore;

public class Somador implements Runnable{
    MyObject eu;

    public Somador(MyObject eu) {
        this.eu = eu;
    }

    public MyObject getEu() {
        return eu;
    }

    public void setEu(MyObject eu) {
        this.eu = eu;
    }

    @Override
    public void run() {
            synchronized (this){
                for (int i = 0; i < 10000; i++) {
                    this.eu.setAge(this.eu.getAge()+1);
                }
            }
        System.out.println("terminamos aqui "+Thread.currentThread().getName());
    }
}
