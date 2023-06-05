import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFromUser = scanner.nextLine();

        WordCounter wordCounter = new WordCounter();
        System.out.println(wordCounter.getCountOfWords(inputFromUser));

    }
}
