import java.util.*;

public class BinaryConverter {
    //binary converter with recursion method.

    public static void main(String[] args){
        //object declaration.
        Scanner scan = new Scanner(System.in);
        BinaryNum numero = new BinaryNum();
        
        //variables declaration.
        int num;

        //User imput num
        System.out.println("please insert a number to convert to binary:");
        numero.bitnum=scan.nextInt();
        numero.bitnum=bit_convert(numero.bitnum);
        System.out.println(numero.bitnum);

    }
}
