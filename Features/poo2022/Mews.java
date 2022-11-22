package poo2022;

import java.io.*;
    public class Mews {

        public static void leitor(String path) throws IOException {
            BufferedReader buffRead = new BufferedReader(new FileReader(path));
            String linha = "";
            while (true) {
                if (linha != null) {
                    System.out.println(linha);
                } else
                    break;
                linha = buffRead.readLine();
            }
            buffRead.close();
        }

        public static void escritor(String path,String c) throws IOException {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            String linha = "";
            buffWrite.append(linha + "\n");
            buffWrite.close();
        }

        public static void codigo() throws IOException {
            int c;
            int p;
            String path = "Features/poo2022/alo.txt";
            leitor(path);
            c = Integer.parseInt(path);
            System.out.print(c);
            p = c + 1;
            //escritor(path,c);
            System.out.print(p);


        }

    }

