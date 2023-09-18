package dev.rayh;

import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

import dev.rayh.domain.Tarefa;
import dev.rayh.domain.tarefas.SalvarArquivo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        String text = "";
        while (true) {
            text = scanner.nextLine();

            if (text.equals("exit()"))
                break;
            new Thread(new SalvarArquivo("apend only", text), "thread").start();
        
        }
    
        scanner.close();
    }
}
