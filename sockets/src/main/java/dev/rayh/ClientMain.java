package dev.rayh;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import dev.rayh.console.ConsolePrinter;

public class ClientMain {

    public static void main(String[] args) {
        String who = args.length > 0 ? args[0] : "System", msg;
        PrintWriter saida;
        BufferedReader entrada;
        Scanner scanner;

        ConsolePrinter.INFO(who, "Iniciando Client");
        try (Socket s = new Socket("localhost", 12345)) {
            ConsolePrinter.INFO(who, "Conectado ao servidor");

            saida = new PrintWriter(s.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
            scanner = new Scanner(System.in);

            new Thread(() -> {
                String response;
                try {
                    while ((response = entrada.readLine()) != null) {
                        ConsolePrinter.INFO(who, "Resposta do servidor: " + response);
                    }
                } catch (Exception e) {
                    ConsolePrinter.ERROR(who, "Erro ao ler do servidor: " + e.getMessage());
                }
            }).start();

            while (true){
                msg = scanner.nextLine();
                saida.println(msg);
            }

        } catch (Exception e) {
            ConsolePrinter.ERROR(who, "Erro ao conectar ao servidor: " + e.getMessage());
        }
    }
}
