import model.Pessoa;

import java.io.*;

public class App {
    public static void main(String[] args) {

        serializar();

        descerealizar();

    }

    private static void descerealizar() {
        try (FileInputStream fis = new FileInputStream("seri.txt")){
            ObjectInputStream ois = new ObjectInputStream(fis);

            Pessoa p = (Pessoa) ois.readObject();
            System.out.println(p.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void serializar() {
        Pessoa pessoa = new Pessoa("Railande", "da Silva e Silva", 22);

        try (FileOutputStream fos = new FileOutputStream("seri.txt")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(pessoa);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
