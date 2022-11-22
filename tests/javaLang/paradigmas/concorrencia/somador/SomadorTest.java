package javaLang.paradigmas.concorrencia.somador;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SomadorTest {
    @Test
    public void testandoConcorrencia(){
        //criar um unico objeto
        MyObject eu = new MyObject("railande", 0);

        Runnable executar = new Somador(eu);

        // iniciando duas threads

        Thread th1 = new Thread(executar, "th1");
        Thread th2 = new Thread(executar, "th2");

        th1.start();
        th2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(20000, eu.getAge());
    }
}
