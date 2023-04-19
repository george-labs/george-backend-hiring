import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        System.out.println("wordcount");

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        System.out.println("Number of words: " + words.length);
    }
}
