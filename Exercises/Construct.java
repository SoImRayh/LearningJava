import java.util.Scanner;

public class Construct {

    String name;
    int age;

    public Construct(){
        name ="jão";
        age= 18;
    }

    public static void main(String[] args){
        Construct eu = new Construct();
        Scanner scan = new Scanner(System.in);

        System.out.format("seu nome é %s e sua idade %d\n",eu.name,eu.age);

        System.out.println("insira seu nome:");
        eu.name=scan.next();
        System.out.println("agora insira sua idade:");
        eu.age=scan.nextInt();
        System.out.format("Seu nome é %s e sua idade é %d",eu.name,eu.age);
    }
}
