import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Subject subject = new Subject();

        for (int i = 0; i < 10; i++) {
            subject.addObserver(new ObserverImpl());
        }

        while( true ){
            subject.addMessage(scanner.nextLine());
        }
    }
}
